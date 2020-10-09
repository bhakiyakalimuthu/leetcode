package com.leetcode.twosum;


import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
//        [2,4,3], l2 = [5,6,4]
        List l1 = new ArrayList();
        l1.add(2);
        l1.add(4);
        l1.add(3);

        List l2 = new ArrayList();
        l2.add(5);
        l2.add(6);
        l2.add(4);

        System.out.println(l1);
        System.out.println(l2);

        TwoSum ts = new TwoSum();
        ListNode ls1 = ts.ListNodeConstructor(l1);
        ListNode ls2 = ts.ListNodeConstructor(l2);

        ts.ListNodePrintValue(ls1);
        ts.ListNodePrintValue(ls2);

//        ts.ListNodePrintValue(ts.Sum(ls1,ls2));
        ts.ListNodePrintValue(ts.addTwoNumbers(ls1,ls2));
    }

    private ListNode Sum(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode ptr = head;
        Integer v1=0, v2=0,sum=0, c = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            } else v1 = 0;
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            } else v2 = 0;
            sum = v1 + v2 + c;
            c = sum / 10;
            sum = sum % 10;
            ListNode tmp = new ListNode(sum);
            ptr.next = tmp;
            ptr = ptr.next;
        }
        if (c != 0) {
            head.next = new ListNode(c);
        }
        return head.next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(-1);
        Integer v1=0,v2=0,c=0;
        ListNode ptr = sum;

        while (l1!=null || l2!=null){
            if (l1!=null){
                v1=l1.val;
                l1=l1.next;
            } else v1=0;
            if (l2!=null){
                v2= l2.val;
                l2=l2.next;
            } else v2=0;
            Integer tmpVar = v1+v2+c;
            Integer actualValue = tmpVar%10;
            c = tmpVar/10;
            ListNode tmpNode = new ListNode(actualValue);
            ptr.next = tmpNode;
            ptr = ptr.next;
        }
        if (c!=0){
            ListNode ln = new ListNode(c);
            ptr.next = ln;
        }
        return sum.next;
    }
    private ListNode ListNodeConstructor(List<Integer> l) {
        ListNode ln = new ListNode(-1);
        ListNode ptr = ln;

        for (int i = 0; i < l.size(); i++) {
            ListNode tmp = new ListNode(l.get(i));
            ptr.next = tmp;
            ptr = ptr.next;
        }
        return ln.next;
    }

    private ListNode CreateNode(Integer x){
       return new ListNode(x);
    }
    private void ListNodePrintValue(ListNode l1){
        while (l1!=null){
            System.out.println(l1.val);
            if (l1.next!=null){
                l1=l1.next;
            }else break;

        }
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}

