package com.summer.algorithms.base;

import java.util.Hashtable;

/**
 * 链表相关操作
 * @author adminstor
 */
public class LinkDemo {
    /**
     * 头结点
     */
    private Node head;
    /**
     * 尾结点
     */
    private Node tail;

    /**
     * 链表添加节点
     * 找到链表的尾结点， 把新添加的数据作为尾结点的后续节点
     * @param data 数据
     */
    public void addNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    /**
     * 链表节点删除
     * 把要删除节点的前节点指向要删除节点的后节点
     * 即直接跳过待删除的节点
     * @param index 要删除节点的下标
     * @return 删除是否成功
     */
    public boolean deleteNode(int index){
        int length = length();
        if(index<1 || index>length){
            return false;
        }
        // 删除头节点
        if(index == 1){
            head = head.next;
            return true;
        }
        Node preNode = head;
        Node curNode = preNode.next;
        int i=2;
        while(curNode!=null){
            // 寻找要删除的节点
            if(i == index){
                preNode.next = curNode.next;
                return true;
            }
            preNode = preNode.next;
            curNode = curNode.next;
            i++;
        }
        return true;
    }

    /**
     * 链表节点排序， 并返回排序后的头节点
     * 选择排序算法， 即每次都选出未排序的节点中最小的节点， 与第一个未排序的节点交换
     * @return 排序后的头节点
     */
    public Node linkSort(){
        Node curNode = head;
        while(curNode.next!=null){
            Node nextNode = curNode.next;
            while(nextNode.next!=null){
                if(curNode.value > nextNode.value){
                    int temp = curNode.value;
                    curNode.value = nextNode.value;
                    nextNode.value = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }

    /**
     * 打印节点信息
     */
    public void printLink(){
        Node curNode = head;
        while (curNode.next != null){
            System.out.println(curNode.value+" ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    public void distinctLink(){
        Node temp = head;
        Node pre = null;
        Hashtable<Integer, Integer> hb = new Hashtable<>();
        while(temp != null){
            //如果hashtable中已经存在该节点， 则跳过该节点
            if(hb.containsKey(temp.value)){
                pre.next = temp.next;
            }else{
                //如果hashtable中不存在该节点， 将节点存到hashtable中
                hb.put(temp.value, 1);
                pre = temp;
            }
            temp = temp.next;
        }
    }

    /**
     * 求链表的长度
     * @return 链表长度
     */
    public int length(){
        int length = 0;
        if(head == null){
            return length;
        }
        Node curNode = head;
        while (curNode.next != null){
            curNode = curNode.next;
            length++;
        }
        return length;
    }

    /**
     * 查找正数第K个元素
     * @param k k
     * @return 找到的元素
     */
    public Node finNode(int k){
        int length = length();
        if(k<1 || k>length){
            return null;
        }
        Node temp = head;
        for(int i=0; i<k-1; i++){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 返回倒数第k个节点
     * 两个指针， 第一个指针向前移动k-1次， 之后两个指针共同前进
     * 当前面的指针到达末尾是， 后面的指针所在的位置就是倒数第k个位置
     * @param k k
     * @return 节点
     */
    public Node findReverNode(int k){
        int length = length();
        if(k<1 || k>length){
            return null;
        }
        Node first = head;
        Node second = head;
        // 第一个指针先向前移动k-1次
        for(int i=0; i<k-1; i++){
            first = first.next;
        }
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }

    /**
     * 反转链表， 在反转指针前一定要保存下个节点的指针
     */
    public void reserveLink(){
        Node curNode = head;
        // 前一个节点
        Node preNode = null;
        while(curNode != null){
            Node nextNode = curNode.next;
            // 指针翻转
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        head = preNode;
    }

    private static class Node{
        int value;
        /**
         * 下一个节点
         */
        Node next = null;

        public Node(int value) {
            this.value = value;
        }
    }
}
