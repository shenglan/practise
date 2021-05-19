package com.lance.practise.utils;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author Shenglan Wang
 */
public class TimerUtils {

  public static void main(String[] args) throws Exception {
    StopWatch watch = new StopWatch();
    watch.start();

    Thread.sleep(1000);
    System.out.println("统计从开始到现在运行时间："+watch.getTime()+"ms");

    Thread.sleep(1000);
    watch.split();
    System.out.println("从开始到第一个切入点运行时间："+watch.getSplitTime());

    Thread.sleep(1000);
    watch.split();
    System.out.println("从开始到第二个切入点运行时间："+watch.getSplitTime());

    watch.reset();
    //重置后必须使用start方法
    watch.start();
    Thread.sleep(1000);
    System.out.println("重新开始后到当前运行时间是："+watch.getTime());

    watch.suspend();
    System.out.println("暂停6秒钟");
    Thread.sleep(6000);

    watch.resume();
    System.out.println("恢复后执行的时间是："+watch.getTime());

    watch.stop();
    System.out.println("花费的时间》》"+watch.getTime()+"毫秒");

  }

}
