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

    /**
     * 寻找单链表的中间节点：
     * 方法一： 先求出链表的长度， 再遍历1/2链表长度， 寻找出链表的中间节点
     * 方法二：
     * 用两个指针遍历链表， 一个快指针， 一个慢指针
     * 快指针每次向前移动2个节点， 慢指针一次向前移动一个节点，
     * 当快指针移动到链表末尾， 慢指针所在的位置即为中间节点所在的位置
     * @return 中间节点
     */
    public Node findMiddleNode(){
        Node slowPoint = head;
        Node quickPoint = head;
        while(quickPoint.next != null && quickPoint.next.next != null){
            slowPoint = slowPoint.next;
            quickPoint = quickPoint.next.next;
        }
        return slowPoint;
    }

    /**
     * 判断链表是否有环
     * 设置快指针和慢指针， 慢指针每次走一步， 快指针每次走两步
     * 当快指针与慢指针相等时， 就说明该链表有环
     * @return 是否有环
     */
    public boolean isRinged(){
        if(head == null){
            return false;
        }
        Node slow = head;
        Node quick = head;
        while(quick.next!=null && quick.next.next!=null){
            slow = slow.next;
            quick = quick.next.next;
            if(slow == quick){
                return true;
            }
        }
        return false;
    }

    /**
     * 返回链表的最后一个节点
     * @return 最后一个节点
     */
    public Node getLastNode(){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 在不知道头节点的情况下删除指定节点
     * 删除按节点的重点在于找出其前节点， 使其前节点的指针指向后节点， 即跳过删除的节点
     * 1 如果待删除的节点是尾结点， 由于单链表不知道其前节点， 没有办法删除
     * 2 如果删除的节点不是尾结点
     * @param n 需要删除的节点信息
     * @return 是否删除成功
     */
    public boolean deleteSpecialNode(Node n){
        if(n.next == null){
            return false;
        }else{
            //交换节点和其后续节点中的数据
            int temp = n.value;
            n.value = n.next.value;
            n.next.value = temp;
            //删除后续节点
            n.next = n.next.next;
            return true;
        }
    }

    /**
     * 判断两个链表是否相交
     * 两个链表相交， 则他们的尾结点一定相同， 比较两个链表的尾结点是否相同即可
     * @param head1 链表1
     * @param head2 链表2
     * @return 是否相交
     */
    public boolean isCross(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        while(temp1.next != null){
            temp1 = temp1.next;
        }
        while (temp2.next != null){
            temp2 = temp2.next;
        }
        return temp1 == temp2;
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
