package com.jia.demo.algorithm.binary_tree;

public class MainDemo {
  public static void main(String[] args) {
    //建立二叉树结点
    BinaryTreeNode node1 = new BinaryTreeNode(1, "宋江");
    BinaryTreeNode node2 = new BinaryTreeNode(2, "吴用");
    BinaryTreeNode node3 = new BinaryTreeNode(3, "卢俊义");
    BinaryTreeNode node4 = new BinaryTreeNode(4, "公孙胜");
    BinaryTreeNode node5 = new BinaryTreeNode(5, "关俊");
    //新建一棵二叉树
    BinaryTreeTraverse tree = new BinaryTreeTraverse(node1);
    //结点添加到二叉树
    node1.setLeftNode(node2);
    node1.setRightNode(node3);
    node3.setLeftNode(node4);
    node3.setRightNode(node5);

    //二叉树的遍历`
    System.out.println("前序遍历二叉树的结果为: ");
    tree.preOrderTraverse();
    System.out.println("=========================");

    System.out.println("中序遍历二叉树的结果为: ");
    tree.midOrderTraverse();
    System.out.println("=========================");

    System.out.println("后序遍历二叉树的结果为: ");
    tree.postOrderTraverse();
    System.out.println("=========================");
  }

}
