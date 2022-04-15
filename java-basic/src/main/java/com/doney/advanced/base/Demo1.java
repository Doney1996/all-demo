package com.doney.advanced.base;

import org.springframework.util.Assert;

import java.util.Random;

//test
//test
public class Demo1 {
    public static void main(String[] args) {

        int[] list = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            Random random = new Random();
            int a = random.nextInt(100);
            list[i] = a;
        }

        throwsMethod(list);

        m2(list);

    }

    private static void m2(int[] list) {
        long l = System.currentTimeMillis();
        for (int i : list) {
            boolean b = ifelse(list[i]);
            if (b) {
                int a = 100;
                a++;
            }
        }
        l = System.currentTimeMillis() - l;
        System.out.println("耗时" + l);
    }

    private static void throwsMethod(int[] list) {
        long l = System.currentTimeMillis();
        for (int i : list) {
            try {
                throwException(list[i]);
            }catch (Exception e){
                String message = e.getMessage();
            }
        }

        l = System.currentTimeMillis() - l;
        System.out.println("耗时" + l);
    }

    public static void throwException(int number){
        boolean good = true;
        Assert.isTrue(number>80,"失败");
    }

    public static boolean ifelse(int number){
       if(number>80){
           return true;
       }else
            return false;
    }
}
