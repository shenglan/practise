package com.lance.practise.algorithm.cache;

import java.util.HashMap;

/**
 * @author Shenglan Wang
 *
 * (未完)
 */
public class LRUCache2 {

    public static class Node{

        private int key;

        private String value;

        private Node before, after;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;

    private Node head, tail;

    private HashMap<Integer, Node> cache = new HashMap<>();

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.head = this.tail = null;
    }

    public Node get(String key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            appendTail(node);
            return node;
        } else {
            return null;
        }
    }

    private void appendTail(Node node) {

    }

    public void put(Integer key, Node node) {
        cache.put(key, node);
        if (cache.size() > capacity) {
            removeHead();
        }
        appendTail(node);
    }

    private void removeHead() {


    }
}
