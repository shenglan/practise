package com.lance.practise.algorithm.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRUCache实现:
 * 1.用队列（先进先出）实现Cache的LRU换出
 * 2.用双向链表来实现队列（和单项链表相比较,双向链表在调整链表结构时更加方便）
 * 3.Put时,进队列并将节点放到队尾,如果Cache空间不足,则换成队首节点; Get时,将节点调整到队尾
 *
 * @author Shenglan Wang
 */
public class LRUCache1<K, V> {

    private int capacity;

    private Map<K, V> cache = new LinkedHashMap<K, V>(16, 0.75f, true){
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    };

    public LRUCache1(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache1<Integer, String> lruCache = new LRUCache1<>(3);
        lruCache.put(1, "11");
        lruCache.put(2, "22");
        lruCache.put(3, "33");
        lruCache.put(4, "44");
        System.out.println(lruCache.get(1));
    }
}
