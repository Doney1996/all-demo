package com.doney.advanced.jvm;

/**
 * 初始化 被动引用
 * 《JVM高级特性与最佳实践》 7-2
 * 虚拟机参数
 * -XX:+TraceClassLoading
 */
public class Code72 {
    public static void main(String[] args) {
        SuperClass72[] aray = new SuperClass72[10];
    }
}

class SuperClass72{
    static {
        System.out.println("SuperClass");
    }

    public static int aa = 1;

}

class SubClass72 extends SuperClass72{
    static {
        System.out.println("SubClass");
    }

}
