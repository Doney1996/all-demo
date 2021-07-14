package com.doney.advanced.thread.lock;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SynchronizedTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                try {
                    A.call(() -> {
                        System.out.println(UUID.randomUUID().toString());
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            list.add(thread);
            Thread.sleep(10);

        }
        List<Thread> list1 = list.subList(0, 50);
        List<Thread> list2 = list.subList(51, 100);
        list1.stream().parallel().forEach(thread->{
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //中间模拟初始化完毕
        Thread t = new Thread(()->{
            try {
                A.change();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.join();

        list2.stream().parallel().forEach(thread->{
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}

@Slf4j
class A{
    private static boolean flag = false;
    private static ArrayList<CallBack> cacheList = new ArrayList<>();

    public static synchronized   void call(CallBack callBack) throws InterruptedException {
        if (flag) {
           log.info("执行callBack{}",callBack.getCallBackName());
           callBack.executor();
        }else {
            cacheList.add(callBack);
        }
    }
    public  static void change() throws InterruptedException {
        if(!flag){
            cacheList.forEach(CallBack::executor);
            log.info("执行所有缓存的callBack，共{}个",cacheList.size());
            cacheList.clear();
            Thread.sleep(100);
            flag = true;
        }
    }




}

interface CallBack{
    /**
     * 回调执行方法
     */
    void executor();

    /**
     * 本回调任务名称
     * @return /
     */
    default String getCallBackName() {
        return Thread.currentThread().getId() + ":" + this.getClass().getName();
    }

}
