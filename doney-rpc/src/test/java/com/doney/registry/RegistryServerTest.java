package com.doney.registry;


import org.junit.Test;

public class RegistryServerTest {

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            new RegistryServer().bootstrap(10080);

        }).start();
            new NettyClient().start();
    }
    @Test
    public void testServer(){

    }

    @Test
    public void testClient(){

    }


}