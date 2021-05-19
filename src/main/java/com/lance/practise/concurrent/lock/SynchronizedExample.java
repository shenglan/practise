package com.lance.practise.concurrent.lock;

/**
 * @author Shenglan Wang
 */
public class SynchronizedExample {

    /**
     * 当没有明确的对象作为锁,只是想让一段代码同步时,可以创建一个特殊的对象,如下.
     */
    private byte[] lock = new byte[0];

    private int value = 0;

    public void print() {
        synchronized (lock) {
            System.out.println("I am in print.");
        }
    }

    public static void lockClass() {
        synchronized (SynchronizedExample.class) {
            System.out.println("I am in lockClass");
        }
    }

    public synchronized void read() {
        String name = Thread.currentThread().getName();
        System.out.println(name + ":" + value);
        write(10);
        System.out.println(name + ":" + value);
        write(20);
    }

    public synchronized void write(int value) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ":" + value);
        this.value = value;
    }

    public synchronized void test1() {
        for (int i = 0; i < 10000; i++) {
            String name = Thread.currentThread().getName();
            System.out.println(name + ": in test1, num=" + i);

            if (i == 0) {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void test2() {
        for (int i = 0; i < 10000; i++) {
            String name = Thread.currentThread().getName();
            System.out.println(name + ": in test2, num=" + i);

            if (i == 0) {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        final SynchronizedExample practise = new SynchronizedExample();
        practise.print();
        SynchronizedExample.lockClass();

        Runnable taskRead = () -> practise.read();
        Runnable taskWrite = () -> practise.write(30);

        new Thread(taskRead).start();
        new Thread(taskRead).start();
        new Thread(taskWrite).start();
        new Thread(taskRead).start();
        new Thread(taskRead).start();

        // Synchronized锁定了this, test1()和test2()不能同时进入
//        new Thread(()->practise.test1()).start();
//        new Thread(()->practise.test2()).start();
    }
}
