package com.doney.advanced.ref;

import java.lang.ref.ReferenceQueue;
import java.util.WeakHashMap;

/**
 * 测试弱引用
 */
public class WeakReference {

    public static void main(String[] args) throws InterruptedException {
        testReference();
    }

    public static void testReference() throws InterruptedException {
        Object needWeakReference = new Object();   // 注意这里是强引用
        //引用队列
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        java.lang.ref.WeakReference<Object> weakReference = new java.lang.ref.WeakReference<Object>
                (needWeakReference, queue);

        //一   强引用还在
        System.out.println("强引用存在");
        System.out.println(weakReference.get());
        System.gc(); // GC
        Thread.sleep(500L);
        System.out.println(weakReference.get());
        System.out.println("===================");

        //二      强引用消失
        System.out.println("强引用消失");
        needWeakReference = null;
        System.out.println(weakReference.get());
        System.out.println("清除强引用之后GC");
        System.gc(); //GC
        Thread.sleep(500L);
        System.out.println(weakReference.get());


    }

    /**
     * 测试 weakHashMap 被GC 之后
     */
    public void testWeakHashMap() throws InterruptedException {
        WeakHashMap<Object, Object> weakHashMap = new WeakHashMap<>();
        Object o = new Object();

        weakHashMap.put(o, "this is set value");
        System.out.println(weakHashMap);
        //去掉强引用
        o = null;
        System.gc();
        Thread.sleep(1000L);


        System.out.println(weakHashMap);

    }

}
