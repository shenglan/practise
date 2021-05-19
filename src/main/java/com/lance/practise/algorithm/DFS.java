package com.lance.practise.algorithm;

import java.util.Stack;

/**
 * @author Shenglan Wang
 */
public class DFS {

    public static void search(TNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.getValue());
        search(root.getLchild());
        search(root.getRchild());
    }

    /**
     * 二叉树的中序遍历：
     * 左边一直压栈到底，再压栈右边的节点
     * @param root
     */
    public static void dfsSearch(TNode root) {
        if (root == null) {
            return;
        }

        Stack<TNode> stack = new Stack<>();
        stack.push(root);
        TNode node = root;
        while (!stack.isEmpty()) {
            if (node.getLchild() != null) {
                stack.push(node.getLchild());
                node = node.getLchild();
            } else {
                node = stack.pop();
                System.out.println(node.getValue());
                if (node.getRchild() != null) {
                    stack.push(node.getRchild());
                    node = node.getRchild();
                }
            }
        }
    }

    public static void main(String[] args) {
        TNode root = TNode.createTree(1, 2, 3, 4, 5, 6, 7);
//        search(root);
        dfsSearch(root);
    }
}
