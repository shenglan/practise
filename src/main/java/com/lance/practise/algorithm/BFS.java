package com.lance.practise.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

import org.eclipse.jetty.util.ArrayQueue;

/**
 * BFS, Breadth First Search.
 * 二叉树分层遍历
 *
 * http://blog.csdn.net/lalor/article/details/7626854
 * @author Shenglan Wang
 */
public class BFS {

    public static List<Integer> search(TNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }

        List<Integer> res = new ArrayList<>();
        Queue<TNode> queue = new ArrayQueue<>();
        TNode node = root;
        while (node != null) {
            res.add(node.getValue());
            if (node.getLchild() != null) {
                queue.offer(node.getLchild());
            }

            if (node.getRchild() != null) {
                queue.offer(node.getRchild());
            }

            node = queue.poll();
        }
        return res;
    }

    public static List<List<Integer>> searchByLevel(TNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TNode> queue = new ArrayQueue<>();
        TNode node = root;
        int parentSize = 1;
        int childSize = 0;

        List<Integer> nums = new ArrayList<>();
        while (node != null) {
            nums.add(node.getValue());
            if (node.getLchild() != null) {
                queue.offer(node.getLchild());
                childSize++;
            }

            if (node.getRchild() != null) {
                queue.offer(node.getRchild());
                childSize++;
            }

            node = queue.poll();
            parentSize--;
            if (parentSize == 0) {
                parentSize = childSize;
                childSize = 0;
                result.add(nums);
                nums = new ArrayList<>();
            }
        }
        return result ;
    }

    public static void main(String[] args) {
        TNode root = TNode.createTree(1, 2, 3, 4, 5, 6, 7);
        List<Integer> nums = search(root);
        System.out.println(nums);

        List<List<Integer>> levels = searchByLevel(root);
        System.out.println(levels);
    }

}
