package com.lance.practise.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic
 * 1.提升代码复用率
 * 2.编译时期做编译检查
 * 3.避免强制类型转换，保证类型安全
 *
 * @author Shenglan Wang
 */
public class GenericExample<T extends Parent, K> {

    private List<T> list;

    private K value;

    public GenericExample(List<T> list, K value) {
        this.list = list;
        this.value = value;
    }

    public static void func1(List<Long> list){
        System.out.println("In func1.");
        for (Long item : list) {
            System.out.println(item);
        }
    }

    public static void func2(List list) {
        System.out.println("in func2.");
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static <T> void func3 (List<T> list){
        System.out.println("in func3.");
        for (T t : list) {
            System.out.println(t);
        }
    }

    public static void func4(List<?> list) {
        System.out.println("in func4.");
//        list.add(1L); 编译错误
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void func5(List<? extends Parent> list) {
        System.out.println("in func5.");
//        list.add(new ClildB()); 编译错误
        for (Parent parent : list) {
            System.out.println(parent);
        }
    }

    public static void func6(List<? super ChildA> list) {
        System.out.println("In func6.");
//        list.add(new Parent()); 编译错误
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(str.length());

        List<Object> list1 = new ArrayList<>();
        list1.add(1L);
        list1.add(str);

        List<Long> list2 = new ArrayList<>();
        list2.add(1L);
        list2.add(2L);

        List list3 = new ArrayList<>();
        list3.add(1L);
        list3.add(str);

//        func1(list1); 编译不通过
        func1(list2);
//        func1(list3); 运行时抛异常 ClassCastException: java.lang.String cannot be cast to java.lang.Long

        func2(list1);
        func2(list2);
        func2(list3);

        List<?> list4 = new ArrayList<>();
        func4(list4);

        List<? extends Parent> list5 = new ArrayList<>();
        func5(list5);

        List<? super ChildA> list6 = new ArrayList<>();
        func6(list6);

        List<ClildB> list7 = new ArrayList<>();
        GenericExample<ClildB, String> example = new GenericExample(list7, "hello");
    }
}

class Parent{}

class ChildA extends Parent{}

class ClildB extends Parent{}
