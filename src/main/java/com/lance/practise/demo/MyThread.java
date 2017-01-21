package com.lance.practise.demo;

/**
 * @author Shenglan Wang
 */
public class MyThread extends Thread {

    private String name;

    public MyThread(String name) {
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
        MyThread thread1 = new MyThread("ThreadA");
        MyThread thread2 = new MyThread("ThreadB");

        thread1.start();

        // 同一个线程start两次，第二次start会因为线程的状态不对，而报错
        thread2.start();
        thread2.start();
    }
}
