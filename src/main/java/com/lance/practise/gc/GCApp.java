package com.lance.practise.gc;

/**
 * http://liuzhaodong89.iteye.com/blog/1668352
 * @author Shenglan Wang
 */
public class GCApp {

  private static final int _1MB = 1024 * 1024;

  /**
   * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
   * -XX:PretenureSizeThreshold=3145728
   *
   9M 的连续数组直接去 Old 区分配了
   /Users/wangshenglan >jstat -gcutil 71809 1000
   S0     S1     E      O      M     CCS    YGC     YGCT    FGC    FGCT     GCT
   0.00   0.00   8.20  90.00  17.28  19.76      0    0.000     0    0.000    0.000
   0.00   0.00   8.20  90.00  17.28  19.76      0    0.000     0    0.000    0.000
   0.00   0.00   8.20  90.00  17.28  19.76      0    0.000     0    0.000    0.000
   0.00   0.00   8.20  90.00  17.28  19.76      0    0.000     0    0.000    0.000
   0.00   0.00   8.20  90.00  17.28  19.76      0    0.000     0    0.000    0.000
   */

//  public static void main(String[] args) {
//    byte[] allocation = new byte[9*_1MB];
//    while(true){
//      try {
//        Thread.sleep(1000);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    }
//  }


  /**
   * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
   * -XX:PretenureSizeThreshold=3145728

   /Users/wangshenglan >jstat -gcutil 72173 1000
   S0     S1     E      O      M     CCS    YGC     YGCT    FGC    FGCT     GCT
   0.00   0.00  51.96  72.71  54.09  56.03      1    0.005     1    0.006    0.011
   0.00   0.00  51.96  72.71  54.09  56.03      1    0.005     1    0.006    0.011
   0.00   0.00  51.96  72.71  54.09  56.03      1    0.005     1    0.006    0.011
   0.00   0.00  51.96  72.71  54.09  56.03      1    0.005     1    0.006    0.011
   0.00   0.00  51.96  72.71  54.09  56.03      1    0.005     1    0.006    0.011

   每个小对象是 1M，没有超过 3145728 (3M)，先在 Eden 区分配，Eden 区大概 8M，到申请第 8 个 1M 的空间时，Eden 区空间不够，
   S0 S1 放不下存活的对象，对象直接进入了 Old 区
   */
    public static void main(String[] args) {
    byte[][] allocation = new byte[11][_1MB]; // 直接分配在老年代中
    while(true){
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
