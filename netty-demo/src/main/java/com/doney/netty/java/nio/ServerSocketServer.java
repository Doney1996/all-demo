package com.doney.netty.java.nio;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerSocketServer {
    static AtomicInteger integer = new AtomicInteger(0);
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        while (true){
            Socket accept = serverSocket.accept();
            if(accept != null){
                Handler handler = new Handler(accept);
                Thread thread = new Thread(handler);
                thread.setName( "socket-thread-" + integer.incrementAndGet());
                thread.start();
            }
        }


        //serverSocketChannel();
    }


    private static void serverSocketChannel() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(10080));
        while (true) {
            try {
                SocketChannel accept = serverSocketChannel.accept();
                if (accept != null) {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int read;
                    while (-1 != (read = accept.read(byteBuffer))) {
                        String string = new String(byteBuffer.array());
                        System.out.println(read);
                        System.out.println(string);
                    }
                    byteBuffer.clear();
                    byteBuffer.put("hello".getBytes());
                    accept.write(byteBuffer);
                    accept.shutdownInput();
                    accept.shutdownOutput();
                    accept.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Handler implements Runnable {

    public Handler(Socket socket){
        this.socket = socket;
    }

    private Socket socket;

    @Override
    public void run() {
        try{

            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[10024];
            StringBuffer request = new StringBuffer();
            while (inputStream.read(bytes) != -1){
                String s = new String(bytes);
                System.out.println(s);
                request.append(s);
            }
            System.out.println(request.toString().length());

            OutputStream outputStream = socket.getOutputStream();

            String body = "good";

            String result = "HTTP /1.1 200 ok \r\n" +
                    "Content-Type:text/html \r\n" +
                    "Content-Length:" + body.getBytes().length + "\r\n" +
                    "\r\n:" + body;
            outputStream.write(result.getBytes());
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
