package com.jia.demo.algorithm.linkedListDemo;

public class MyLinkedList {

  int size;
  ListNode head;

  public MyLinkedList() {
    size = 0;
    head = new ListNode(0);
  }

  //在链尾增加节点
  public void add(ListNode node) {
    ListNode temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    size++;
    temp.next = node;
  }

  //在链头插入节点
  public void addEnd(ListNode node) {
    if (head == null) {
      size++;
      head = node;
      return;
    }
    node.next = head;
    size++;
    head = node;
  }

  // 删除某个节点
  public void remove(int val) {
    while (head != null) {
      if (head.value != val) {
        break;
      }
      head = head.next;
    }
    ListNode cur = head;
    ListNode pre = head;
    while (cur != null) {
      if (cur.value == val) {
        pre.next = cur.next;
      } else {
        pre = cur;
      }
      cur = cur.next;
    }
  }


}
