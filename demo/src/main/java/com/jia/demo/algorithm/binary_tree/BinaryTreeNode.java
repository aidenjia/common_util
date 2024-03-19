package com.jia.demo.algorithm.binary_tree;

public class BinaryTreeNode {

  private BinaryTreeNode leftNode;
  private BinaryTreeNode rightNode;
  private int id;
  private String name;

  //带参构造, 初始化结点的数据
  public BinaryTreeNode(int id, String name) {
    this.id = id;
    this.name = name;
  }

  // 设置结点的左孩子结点
  public void setLeftNode(BinaryTreeNode node) {
    this.leftNode = node;
  }

  //设置结点的右孩子节点
  public void setRightNode(BinaryTreeNode node) {
    this.rightNode = node;
  }

  //重写输出结点数据信息的toString()
  @Override
  public String toString() {
    return "id : " + id + ", name: " + name;
  }

  public void preOrder() {
    //输出父节点
    System.out.println(this);
    //遍历输出左子树
    if (this.leftNode != null) {
      this.leftNode.preOrder();
    }
    //遍历输出右子树
    if (this.rightNode != null) {
      this.rightNode.preOrder();
    }
  }

  //2. 中序遍历
  public void midOrder() {
    //遍历左子树
    if (this.leftNode != null) {
      this.leftNode.midOrder();
    }
    //输出父节点
    System.out.println(this);
    //遍历右子树
    if (this.rightNode != null) {
      this.rightNode.midOrder();
    }
  }

  //3. 后序遍历
  public void postOrder() {
    //遍历左子树
    if (this.leftNode != null) {
      this.leftNode.postOrder();
    }
    //遍历右子树
    if (this.rightNode != null) {
      this.rightNode.postOrder();
    }
    System.out.println(this);
  }

  public BinaryTreeNode midOrderSearchById(int id) {
    if (this.id == id) {
      return this;
    }
    BinaryTreeNode res = null;
    if (this.leftNode != null) {
      res = this.leftNode.midOrderSearchById(id);
    }
    if (res != null) {
      return res;
    }
    if (this.rightNode != null) {
      res = this.rightNode.midOrderSearchById(id);
    }
    if (res != null) {
      return res;
    } else {
      return null;
    }
  }

  public void deleteNodeById(int id) {
    if (this.leftNode != null && this.leftNode.id == id) {
      this.leftNode = null;
      return;
    }
    if(this.rightNode!=null && this.rightNode.id == id){
      this.rightNode =null;
      return;
    }
    if(this.leftNode!=null){
      this.leftNode.deleteNodeById(id);
    }
    if(this.rightNode!=null){
      this.rightNode.deleteNodeById(id);
    }
  }
}
