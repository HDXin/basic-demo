package top.atstudy.basic.suanfa;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/16 23:24
 */

public class Solution {

    public static void main(String[] args) {
        ListNode L2 = new ListNode(4);
        L2.setNext(new ListNode(3));

        ListNode L1 = new ListNode(2);
        L1.setNext(L2);


        ListNode M2 = new ListNode(6);
        M2.setNext(new ListNode(4));

        ListNode M1 = new ListNode(5);
        M1.setNext(M2);

        //
        ListNode L5 = addTwoNumbers3(new ListNode(5), new ListNode(5));
//        ListNode L5 = addTwoNumbers3(L1, M1);
        System.out.println(" ===>> ");
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode parent = null;
        Integer cach = 0;
        do{
            Integer a1 = l1 == null ? 0:l1.getVal();
            Integer a2 = l2 == null ? 0:l2.getVal();
            Integer temp = (a1 + a2 + cach)%10;
            ListNode now = new ListNode(temp);

            if(parent == null){
                root = now;
                parent = now;
            }else{
                parent.setNext(now);
                parent = now;
            }

            cach = (a1 + a2 + cach)/10;
            l1 = l1.getNext() == null ? null:l1.getNext();
            l2 = l2.getNext() == null ? null:l2.getNext();
        }while (l1 != null || l2 != null);

        if(cach != 0){
            parent.setNext(new ListNode(cach));
        }

        return root;
    }

    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode parent = null;
        Integer cach = 0;
        while (l1 != null || l2 != null || cach != 0){

            Integer a1 = l1 == null ? 0:l1.getVal();
            Integer a2 = l2 == null ? 0:l2.getVal();

            Integer temp = (a1 + a2 + cach)%10;
            ListNode now = new ListNode(temp);

            if(parent == null){
                root = now;
                parent = now;
            }else{
                parent.setNext(now);
                parent = now;
            }

            cach = (a1 + a2 + cach)/10;
            l1 = l1 == null ? null:l1.getNext();
            l2 = l2 == null ? null:l2.getNext();
        }

        return root;
    }




    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }
    }
}