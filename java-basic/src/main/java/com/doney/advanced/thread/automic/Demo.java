package com.doney.advanced.thread.automic;

import java.util.concurrent.atomic.*;
import java.util.function.IntBinaryOperator;

/**
 * JDk 提供的原子操作
 */
public class Demo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(1);

        //反射 安全修改对象中volatile 修饰的long 或者 int
        AtomicIntegerFieldUpdater<Person> mAtoLong = AtomicIntegerFieldUpdater.newUpdater(Person.class, "id");
        Person person = new Person(1);
        mAtoLong.compareAndSet(person, 12345, 1000);



        //原子引用
        AtomicReference<Object> objectAtomicReference = new AtomicReference<>();
        //原子引用 数组
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(1);

        //原子引用 附带一个mark标记 ，mark为 boolean类型
        Person p2 = new Person(2);
        AtomicMarkableReference<Object> objectAtomicMarkableReference = new AtomicMarkableReference<>(p2, true);

        //原子引用 附带一个时间戳功能
        Person p3 = new Person(1);
        AtomicStampedReference<Object> objectAtomicStampedReference = new AtomicStampedReference<>(p3,1);
        boolean b = objectAtomicStampedReference.attemptStamp(p3, 2); //拿着对象引用，更改时间戳
        System.out.println(b);
        System.out.println(objectAtomicStampedReference.getStamp());
        System.out.println(objectAtomicStampedReference.compareAndSet(p3, new Object(), 2, 5));// 同时更改时间戳和对象引用
        int stamp = objectAtomicStampedReference.getStamp();
        System.out.println(stamp);



        //并行累加器
        Longadder();

        //并行计算器
        Accumulator();

    }

    /**
     * 高级的并行计算器
     * 性能高于
     *@see  AtomicInteger#accumulateAndGet(int, IntBinaryOperator)
     */
    private static void Accumulator() throws InterruptedException {
        LongAccumulator longAccumulator = new LongAccumulator((a, b) -> {
            return a * b;
        }, 1);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> longAccumulator.accumulate(10L));
            thread.start();
            thread.join();
        }
        System.out.println(longAccumulator);
    }

    /**
     * 累加器
     * 性能高于
     * @see AtomicInteger#incrementAndGet()
     */
    private static void Longadder() throws InterruptedException {
        LongAdder longAdder = new LongAdder();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> longAdder.add(1));
            thread.start();
            thread.join();
        }
        System.out.println(longAdder.sum());
    }

}

class Person {
    public Person(int id) {
        this.id = id;
    }

    volatile int id;//不能是private 修饰，且为 long 或者 int

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
