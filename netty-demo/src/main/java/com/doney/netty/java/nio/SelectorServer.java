package com.doney.netty.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorServer {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel channel = ServerSocketChannel.open();
         channel.bind(new InetSocketAddress(9999));
        channel.configureBlocking(false);


        Selector selector = Selector.open();

        channel.register(selector, SelectionKey.OP_ACCEPT);




        ByteBuffer readBuff = ByteBuffer.allocate(1024);
        ByteBuffer writeBuff = ByteBuffer.allocate(128);

        for (;;){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();

                if (key.isAcceptable()) {
                    // 创建新的连接，并且把连接注册到selector上，而且，
                    // 声明这个channel只对读操作感兴趣。
                    SocketChannel socketChannel = channel.accept();
                    socketChannel.configureBlocking(false);
                  //  socketChannel.register(selector, SelectionKey.OP_READ);
                }

                if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    readBuff.clear();
                    socketChannel.read(readBuff);

                    readBuff.flip();
                    System.out.println("received : " + new String(readBuff.array()));
                    //key.interestOps(SelectionKey.OP_WRITE);
                }

                keyIterator.remove();
            }
        }



    }

}
