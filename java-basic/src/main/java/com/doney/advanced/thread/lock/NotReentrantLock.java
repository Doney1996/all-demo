package com.doney.advanced.thread.lock;

/**
 * 不可重入锁演示
 */
public class NotReentrantLock {
    static Lock lock = new Lock();
    public static void main(String[] args) throws InterruptedException {
        print();
    }
    public static void print() throws InterruptedException {
        lock.lock();
        doAdd();
        lock.unlock();
    }

    /**
     * 再次尝试加锁
     */
    public static void doAdd() throws InterruptedException {
        lock.lock();
        //do something
        lock.unlock();
    }
}

/**
 * 不可重入锁
 */
class Lock {
    private boolean isLocked = false;

    /**
     * 当锁进来再次check
     */
    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}

/**
 * 可重入锁
 * 内部维护计数器和当前线程
 */
class ReenTrantLock{
    boolean isLocked = false;
    Thread  lockedBy = null;
    int lockedCount = 0;
    public synchronized void lock()
            throws InterruptedException{
        Thread thread = Thread.currentThread();
        while(isLocked && lockedBy != thread){
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = thread;
    }
    public synchronized void unlock(){
        if(Thread.currentThread() == this.lockedBy){
            lockedCount--;
            if(lockedCount == 0){
                isLocked = false;
                notify();
            }
        }
    }
}