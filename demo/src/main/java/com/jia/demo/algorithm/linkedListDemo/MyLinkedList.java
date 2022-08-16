package com.jia.demo.algorithm.linkedListDemo;

public class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList(){
        size=0;
        head=new ListNode(0);
    }

    //获取第index个节点
    public int get(int index){
        if(index<0||index>=size){
            return -1;
        }
        ListNode currentNode=head;
        for(int i=0;i<=index;i++){
            currentNode=currentNode.next;
        }
        return currentNode.value;
    }

    public void addIndex(int index,int value){
        if(index>size){
            return;
        }
        if(index<0){
            index=0;
        }
        size++;
        ListNode pred=head;
        for(int i=0;i<index;i++){
            pred=pred.next;
        }
        ListNode addNode=new ListNode(value);
        addNode.next=pred.next;
        pred.next=addNode;
    }

    public void removeNode(int index){
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode pred=head;
        for(int i=0;i<index;i++){
            pred=pred.next;
        }
        pred.next=pred.next.next;
    }
}
