package com.lance.practise.misc;

/**
 * @author Shenglan Wang
 */
public class ThreadDemo extends Thread {

    private String name;

    public ThreadDemo(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread start: "+this.name+", i="+i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo thread1 = new ThreadDemo("ThreadA");
        ThreadDemo thread2 = new ThreadDemo("ThreadB");

        thread1.start();

        // 同一个线程start两次，第二次start会因为线程的状态不对，而报错
        thread2.start();
        thread2.start();
    }
}
