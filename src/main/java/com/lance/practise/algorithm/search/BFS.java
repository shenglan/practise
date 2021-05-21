package com.lance.practise.algorithm.search;

import java.util.Collections;
import java.util.List;
import java.util.Queue;

import com.google.common.collect.Lists;
import org.eclipse.jetty.util.ArrayQueue;

/**
 * BFS, Breadth First Search.
 * 二叉树分层遍历
 * <p>
 * http://blog.csdn.net/lalor/article/details/7626854
 *
 * @author Shenglan Wang
 */
public class BFS {

  public static List<Integer> bfs(TNode root) {
    if (root == null) {
      return Collections.emptyList();
    }

    List<Integer> nodes = Lists.newArrayList();
    Queue<TNode> queue = new ArrayQueue<>();
    TNode node = root;
    while (node != null) {
      nodes.add(node.getValue());
      TNode lchild = node.getLchild();
      TNode rchild = node.getRchild();
      if (lchild != null) {
        queue.offer(lchild);
      }
      if (rchild != null) {
        queue.offer(rchild);
      }
      node = queue.poll();
    }
    return nodes;
  }

  public static List<List<Integer>> bfsByLevel(TNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = Lists.newArrayList();

    Queue<TNode> queue = new ArrayQueue<>();
    TNode node = root;
    List<Integer> nodes = Lists.newArrayList();
    int parentNum = 1;
    int childSize = 0;
    while (node != null) {
      nodes.add(node.getValue());
      TNode lnode = node.getLchild();
      TNode rnode = node.getRchild();
      if (lnode != null) {
        queue.offer(lnode);
        childSize++;
      }
      if (rnode != null) {
        queue.offer(rnode);
        childSize++;
      }

      node = queue.poll();
      parentNum--;
      if (parentNum == 0) {
        parentNum = childSize;
        childSize = 0;
        result.add(nodes);
        nodes = Lists.newArrayList();
      }
    }
    return result;
  }

  public static void main(String[] args) {
    TNode root = TNode.createTree(1, 2, 3, 4, 5, 6, 7);
    List<Integer> nodes = bfs(root);
    System.out.println(nodes);

    List<List<Integer>> nodesByLevel = bfsByLevel(root);
    System.out.println(nodesByLevel);
  }
}
