package com.lance.practise.misc;

/**
 * @author Shenglan Wang
 */
public class OuterClass {

  private static final int flag = 10;

  private String name;
  private int age;

  public void display() {
    System.out.println("OuterClass...");
  }

  public static void print() {
    System.out.println("abc...");
  }

  public class InnerClass {

    public InnerClass() {
      name = "chenssy";
      age = 23;
    }

    public void display() {
      System.out.println("InnerClass: name: " + name + ", age: " + age);
    }

    public OuterClass getOuterClass() {
      return OuterClass.this;
    }
  }

  public static class StaticInnerClass {

    public void display() {
//      System.out.println("Static InnerClass: name: " + name + ", age: " + age);
      System.out.println("Static InnerClass: flag: " + flag);
      print();
    }
  }

  public static void main(String[] args) {
    OuterClass outerClass = new OuterClass();
    OuterClass.InnerClass innerClass = outerClass.new InnerClass();
    innerClass.display();
    innerClass.getOuterClass().display();

    StaticInnerClass staticInnerClass = new StaticInnerClass();
    staticInnerClass.display();
  }
}