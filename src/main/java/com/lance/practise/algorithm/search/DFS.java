package com.lance.practise.algorithm.search;

import java.util.Stack;

/**
 * @author Shenglan Wang
 */
public class DFS {

  public static void dfsByRecursive(TNode root) {
    if (root == null) {
      return;
    }

    dfsByRecursive(root.getLchild());
    process(root);
    dfsByRecursive(root.getRchild());
  }

  /**
   * 二叉树的中序遍历：
   * 左边一直压栈到底，再压栈右边的节点
   *
   * @param root
   */
  public static void dfs(TNode root) {
    if (root == null) {
      return;
    }

    Stack<TNode> stack = new Stack<>();
    TNode node = root;
    stack.push(root);
    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        node = node.getLchild();
        if (node != null) {
          stack.push(node);
        }
      }

      node = stack.pop();
      process(node);
      node = node.getRchild();
      if (node != null) {
        stack.push(node);
      }
    }
  }

  private static void process(TNode node) {
    System.out.println(node.getValue());
  }

  public static void main(String[] args) {
    TNode root = TNode.createTree(1, 2, 3, 4, 5, 6, 7);

    dfsByRecursive(root);
    dfs(root);
  }
}
