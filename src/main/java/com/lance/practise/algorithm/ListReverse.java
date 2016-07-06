package com.lance.practise.algorithm;

/**
 * 在JAVA里面如何表示链表，栈和队列？
 * - 链表和数组是两种基本的数据结构，栈和队列基于链表或数组来实现。
 * - 在JAVA Collection里面:
 *   - List（ArrayList 数组，LinkedList 链表），
 *   - Queue （ArrayQueue 数组，LinkedBlockingQueue 链表）
 *   - Vector（Stack的父类 数组)
 *
 * @author Shenglan Wang
 */
public class ListReverse {

    public static class ListNode<T> {

        private T data;

        private ListNode<T> nextNode;

        public ListNode() {
        }

        public ListNode(T data, ListNode<T> nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }

        public T getData() {
            return data;
        }

        public ListNode<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(ListNode<T> nextNode) {
            this.nextNode = nextNode;
        }
    }

    public static <T> void reverse(ListNode<T> head) {
        if (head == null || head.getNextNode() ==null) {
            return;
        }

        ListNode<T> curNode = head.getNextNode().getNextNode();
        ListNode<T> prevNode = head.getNextNode();
        while (curNode != null) {
            prevNode.setNextNode(curNode.getNextNode());

            ListNode<T> headNext = head.getNextNode();
            head.setNextNode(curNode);
            curNode.setNextNode(headNext);

            curNode = prevNode.getNextNode();
        }
    }

    public static <T> ListNode<T> create(T[] data) {
        if (data == null || data.length == 0) {
            return null;
        }

        ListNode<T> head = new ListNode();
        ListNode<T> prevNode = head;
        for (T t : data) {
            ListNode<T> curNode = new ListNode<>(t, null);
            prevNode.setNextNode(curNode);
            prevNode = curNode;
        }
        return head;
    }

    public static <T> void print(ListNode<T> head) {
        if (head == null) {
            return;
        }

        ListNode<T> node = head.getNextNode();
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNextNode();
        }
    }

    public static void main(String[] args) {
        ListNode<Integer> head = create(new Integer[]{ 1, 2, 3, 4, 5 });
        print(head);
        reverse(head);
        print(head);
    }
}
