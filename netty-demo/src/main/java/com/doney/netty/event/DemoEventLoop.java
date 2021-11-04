package com.doney.netty.event;

import io.netty.channel.nio.NioEventLoopGroup;

import java.util.concurrent.ExecutionException;

//拥有一个NioEventLoopGroup可以干嘛
public class DemoEventLoop {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup(100);
    }

}
