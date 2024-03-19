package com.jia.demo.algorithm.binary_tree;

public class BinaryTreeTraverse {

  private BinaryTreeNode root;

  public BinaryTreeTraverse(BinaryTreeNode node) {
    this.root = node;
  }

  //通过判断父节点是否为空, 我们来决定二叉树遍历的开始和结束
  public void preOrderTraverse() {
    if (root != null) {
      root.preOrder();
    } else {
      System.out.println("二叉树为空, 前序遍历失败!");
    }
  }

  public void midOrderTraverse() {
    if (root != null) {
      root.midOrder();
    } else {
      System.out.println("二叉树为空, 中序遍历失败!");
    }
  }

  public void postOrderTraverse() {
    if (root != null) {
      root.postOrder();
    } else {
      System.out.println("二叉树为空, 后序遍历失败");
    }
  }

}
