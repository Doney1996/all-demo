package com.doney.advanced.thread;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 测试 ThreadLocal可以是多个
 */
public class ThreadLocalTest {

    public static ThreadLocal<Object> tl1 = new ThreadLocal<>();
    public static ThreadLocal<Object> tl2 = new ThreadLocal<>();

    public static Map<Thread, Object> threadObjectMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        testThreadLocal();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                tl1.set(UUID.randomUUID());
                tl2.set(UUID.randomUUID());
                threadObjectMap.put(Thread.currentThread(), UUID.randomUUID().toString());

                System.out.println(tl1.get());
                System.out.println(tl2.get());
            });
            thread.start();
            thread.join();


        }

        threadObjectMap.forEach((key,value)->{
            if (!key.isAlive()) {
                threadObjectMap.remove(key);
            }
        });




    }

    private static void testThreadLocal() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                tl1.set(UUID.randomUUID());
                tl2.set(UUID.randomUUID());
                System.out.println(tl1.get());
                System.out.println(tl2.get());
            });
            thread.start();
            thread.join();
        }
    }

}
