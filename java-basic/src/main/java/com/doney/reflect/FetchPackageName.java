package com.doney.reflect;

import java.util.Arrays;

public class FetchPackageName {
    public static void main(String[] args) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        System.out.println(Arrays.toString(stackTrace));
    }
}
