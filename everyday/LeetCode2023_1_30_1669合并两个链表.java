package everyday;

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
public class LeetCode2023_1_30_1669合并两个链表 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode preA = list1;
        ListNode subB = list1;
        for (int i = 0; i < a - 1; i++) {
            preA = preA.next;
        }
        for (int i = 0; i < b + 1; i++){
            subB = subB.next;
        }
        preA.next = list2;
        while (list2.next!=null){
            list2 = list2.next;
        }
        list2.next = subB;
        return list1;
    }
}
