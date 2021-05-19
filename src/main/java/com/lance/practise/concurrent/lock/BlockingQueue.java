package com.lance.practise.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞队列的实现,生产者/消费者模型
 *
 * @see java.util.concurrent.ArrayBlockingQueue
 * @author Shenglan Wang
 */
public class BlockingQueue<T> {

    private T[] queue;

    private int head;

    private int tail;

    private int count;

    private final int capacity;

    private final ReentrantLock lock = new ReentrantLock();

    private final Condition notFull = lock.newCondition();

    private final Condition notEmpty = lock.newCondition();

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = (T[])new Object[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public T take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            return dequeue();
        } finally {
            lock.unlock();
        }
    }
    
    public void put(T t) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (count == getCapacity()) {
                notFull.await();
            }
            enqueue(t);
        } finally {
            lock.unlock();
        }
    }

    private T dequeue() {
        T t = queue[head];
        if (++head == getCapacity()) {
            head = 0;
        }
        count--;
        notFull.signal();
        return t;
    }

    private void enqueue(T t) {
        queue[tail] = t;
        if (++tail == getCapacity()) {
            tail = 0;
        }
        count++;
        notEmpty.signal();
    }

    public static void main(String[] args) {
        final BlockingQueue<Integer> queue = new BlockingQueue<>(100);
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 300; i++) {
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Runnable consumerTask = ()-> {
            while (1 == 1) {
                String name = Thread.currentThread().getName();
                try {
                    System.out.println(name + ":" + queue.take());
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread consumer1 = new Thread(consumerTask);
        Thread consumer2 = new Thread(consumerTask);
        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
