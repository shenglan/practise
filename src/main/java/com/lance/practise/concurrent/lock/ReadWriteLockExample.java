package com.lance.practise.concurrent.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读锁是共享锁,写锁是排他锁
 *
 * @see <a href="http://pi88dian88.iteye.com/blog/2017045"/>
 * @author Shenglan Wang
 */
public class ReadWriteLockExample {
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    public void read() {
        readLock.lock();
        try {
            System.out.println(format.format(new Date()) + "---read---");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public void write() {
        writeLock.lock();
        try {
            System.out.println(format.format(new Date()) + "---write---");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static class MyThread extends Thread {
        private ReadWriteLockExample readWriteLockPractise;
        private String methodName;

        public MyThread(ReadWriteLockExample readWriteLockTest, String methodName) {
            super();
            this.readWriteLockPractise = readWriteLockTest;
            this.methodName = methodName;
        }

        @Override
        public void run() {
            if ("read".equalsIgnoreCase(methodName))
                readWriteLockPractise.read();
            else
                readWriteLockPractise.write();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExample practise = new ReadWriteLockExample();
        Thread t1 = new MyThread(practise, "read");
        Thread t2 = new MyThread(practise, "write");
        t1.start();
        t2.start();
    }
}
