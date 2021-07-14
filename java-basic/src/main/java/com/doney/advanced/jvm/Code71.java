package com.doney.advanced.jvm;

/**
 * 初始化 被动引用
 * 《JVM高级特性与最佳实践》 7-1
 * 虚拟机参数
 * -XX:+TraceClassLoading
 */
public class Code71 {
    public static void main(String[] args) {
        System.out.println(SuperClass.aa);
    }
}
class SuperClass{
    static {
        System.out.println("SuperClass");
    }

    public static final int aa = 1;

}

class SubClass extends SuperClass{
    static {
        System.out.println("SubClass");
    }

}
