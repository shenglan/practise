package com.lance.practise.concurrent.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Shenglan Wang
 */
public class CyclicBarrierPractise {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        String a = "abc";
        System.out.println(a.getBytes().length);
        
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N + 1);
        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();
        }
        System.out.println("Started!");
        barrier.await();

        barrier.await();
        System.out.println(Thread.currentThread().getName() + "继续处理其他任务...");
        barrier.await();
        System.out.println(Thread.currentThread().getName() + "finish");
    }

    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+"正在写入数据...");

                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println(Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"继续处理其他任务...");
            try {
                Thread.sleep(5000);
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+" finish");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}