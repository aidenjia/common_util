package com.jia.demo.algorithm.linkedListDemo;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;// 保存下一个节点
            //然后将当前节点指向pre
            cur.next = prev;
            //pre和cur节点都前进一位
            prev = cur;
            cur = temp;
        }
        return prev;
    }


}
