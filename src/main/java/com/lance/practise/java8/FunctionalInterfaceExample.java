package com.lance.practise.java8;

/**
 * 用@FunctionalInterface做函数式接口申明,检查编译错误
 *
 * @author Shenglan Wang
 */
@FunctionalInterface
public interface FunctionalInterfaceExample {
    void read();

//    void write(); //compile error

    default void printHello() {
        System.out.println("Hello");
    }

    static void printWorld() {
        System.out.println("World");
    }
}
