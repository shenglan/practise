package com.lance.practise.concurrent.lock;

/**
 * Volatile 不具备原子性,能保证可见性和禁止指令重排序
 *
 * @author Shenglan Wang
 */
public class VolatileExample {

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final VolatileExample test = new VolatileExample();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100000; j++)
                    test.increase();
            }).start();
        }

        while (Thread.activeCount() > 1)
            // 保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }
}
