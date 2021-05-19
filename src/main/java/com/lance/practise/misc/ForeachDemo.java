package com.lance.practise.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * https://blog.csdn.net/wangjun5159/article/details/61415358
 *
 * @author Shenglan Wang
 */
public class ForeachDemo {

  public static void main(String[] args) {
    List<String> a = new ArrayList<>();
    a.add("1");
    a.add("2");
//    for (String temp : a) {
//      if("2".equals(temp)){
//        a.remove(temp);
//      }
//    }

//    Iterator<String> it= a.iterator();
//    while(it.hasNext()){
//      String temp = it.next();
//      if("2".equals(temp)){
//        it.remove();
//      }
//    }
//    System.out.println(a);
//  }

    List<String> b = new ArrayList<>();
    b.add("1");
    b.add("2");
    b.add("3");
    b.add("4");
    b.add("5");
    b.add("6");

//    System.out.println(b);
//    for (int i = 0; i < b.size(); i++) {
//
//      String e = b.get(i);
//
//      if ("1".equals(e)) {
//        b.remove(i);
//        i = i - 1; //修正index
//      } else {
//        b.set(i, e + "1");
//      }
//    }
//    System.out.println(b);
    b.removeIf(s -> s.equals("3"));
    System.out.println(b);

  }
}

