package 算法.模拟;

import publicClass.ListNode;

/**
 * Definition for singly-linked list.
 * public class publicClass.ListNode {
 * int val;
 * publicClass.ListNode next;
 * publicClass.ListNode() {}
 * publicClass.ListNode(int val) { this.val = val; }
 * publicClass.ListNode(int val, publicClass.ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode newList = new ListNode();
        while (l1.next != null && l2.next != null) {
            newList.val = (l1.val + l2.val) % 10 + sum;
            sum = (l1.val + l2.val) / 10;
            newList = newList.next;
        }
        return newList;
    }
}