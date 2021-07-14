package com.doney.advanced.lambda;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 测试在lambda中使用外部变量
 */
public class lambdaTest {

    public static void main(String[] args) {
        AtomicReference<String> a = new AtomicReference<>("");
        String b = "";//Variable used in lambda expression should be final or effectively final
        //lambda表达式中使用的变量应该是final或有效的final
        new Thread(
                ()->{
                    while (true) {
                        a.set(UUID.randomUUID().toString());
                        // b="123";
                    }
                }
        ).start();

    }

}
