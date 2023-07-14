package com.lance.practise.algorithm.search;

import lombok.Data;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Shenglan Wang
 */
@Data
public class TNode {
    private TNode lchild;
    private TNode rchild;
    private int value;

    public TNode(int value) {
        this.value = value;
    }

    public static TNode createTree(int... nums) {
        if (nums.length == 0) {
            return null;
        }

        TNode root = new TNode(nums[0]);
        TNode node = root;
        Queue<TNode> queue = new PriorityQueue<>();
        for (int i = 1; i < nums.length; i++) {
            TNode lnode = new TNode(nums[i]);
            node.setLchild(lnode);
            queue.offer(lnode);

            i++;
            if (i < nums.length) {
                TNode rnode = new TNode(nums[i]);
                node.setRchild(rnode);
                queue.offer(rnode);
            }
            node = queue.poll();
        }
        return root;
    }

    public static void main(String[] args) {
        createTree(1, 2, 3, 4, 5);
    }
}