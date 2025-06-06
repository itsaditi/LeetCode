/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseListItertively(ListNode head) {
        if (head == null || head.next == null) return head;

        // Time complexity --> O(N)
        // Space complexity --> O(1)
        ListNode currNode = head;
        ListNode nextNode = head.next;

        while (nextNode != null) {
            ListNode nextCurrNode = nextNode;
            ListNode nextNextNode = nextNode.next;

            nextNode.next = currNode;
            if (currNode == head) {
                currNode.next = null;
            }

            currNode = nextCurrNode;
            nextNode = nextNextNode;
        }

        return currNode;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }
}