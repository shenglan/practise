package com.lance.practise.algorithm;

/**
 * 设计一个栈,能在O(1)时间内找到最小元素:
 *
 * 关于栈的表示:
 * - JDK Collection
 *   List ArrayList基于数组, LinkedList基于链表
 *   Vector(Stack的父类, 不太常用?) 基于数组
 *   Queue ArrayQueue基于数组, LinkedBlockingQueue基于链表
 *
 * 思路:
 * - value = (x - min)
 *
 * @author Shenglan Wang
 */
public class MinimumStack {

    private int[] data;

    private int validLength;

    private int size;

    private int min;

    public MinimumStack(int size) {
        this.validLength = 0;
        this.size = size;
        this.data = new int[size];
    }

    public int getMin() {
        return min;
    }

    public void push(int num) {
        if (validLength == size) {
            throw new RuntimeException("not enough space");
        }

        if (validLength == 0) {
            min = num;
        }

        int value = num - min;
        data[validLength++] = value;

        if (value < 0) {
            min = num;
        }
    }

    public int pop() {
        if (validLength == 0) {
            throw new RuntimeException("empty stack");
        }

        int res;
        int value = data[--validLength];
        if (value >= 0) {
            res = value + min;
        } else {
            res = min;
            min = min - value;
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumStack stack = new MinimumStack(5);
        stack.push(1);
        System.out.println(stack.getMin());
        stack.push(2);
        System.out.println(stack.getMin());
        stack.push(3);
        System.out.println(stack.getMin());
        stack.push(-1);
        System.out.println(stack.getMin());
        stack.push(1);
        System.out.println(stack.getMin());

        System.out.println(stack.pop());
        System.out.println(stack.getMin());

        System.out.println(stack.pop());
        System.out.println(stack.getMin());

        System.out.println(stack.pop());
        System.out.println(stack.getMin());

        System.out.println(stack.pop());
        System.out.println(stack.getMin());

        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }
}
