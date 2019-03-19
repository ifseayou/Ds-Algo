package com.isea.dw.leetcode;

/**
 * LeetCode-203
 * 移除链表中所有的目标元素
 */
public class RemoveElement {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }

        @Override
        public String toString(){
            StringBuilder res = new StringBuilder();
            ListNode cur = this;
            while (cur != null){
                res.append(cur.val + "->");
                cur = cur.next;
            }
            res.append("NULL");
            return res.toString();
        }

    }

    // 递归解法 ，将当前节点和当前节点的后续节点分开考虑
    public static   ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode res = removeElements(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(6);
        System.out.println(head);

        ListNode res = (removeElements(head,6));
        System.out.println(res);
    }

}
