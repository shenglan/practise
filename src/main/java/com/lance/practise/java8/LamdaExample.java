package com.lance.practise.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Lamda
 *
 * @author Shenglan Wang
 */
public class LamdaExample {
    public static void main(String[] args) {
        // thread, way 1, wrong way?
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        thread1.start();

        // thread, way 2, right way?
        Thread thread2 = new Thread(() -> System.out.println("hello in lamda"));
        thread2.start();

        Runnable run = () -> System.out.println("hello in lamda");


        //print list, old way:
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        for(Integer n: list1) {
            System.out.println(n);
        }

        //print list, new way:
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list2.forEach(n -> System.out.println(n));
        //print list, or we can use :: double colon operator in Java 8
        list2.forEach(System.out::println);



        //对每个元素求平方:
        List<Integer> list3 = Arrays.asList(1,2,3,4,5,6,7);
        list3.stream().map((x) -> x*x).forEach(System.out::println);

        //对每个元素求平方,在求和:
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        int sum = list.stream().map(x -> x*x).reduce((x,y) -> x + y).get();
        System.out.println(sum);
    }
}
