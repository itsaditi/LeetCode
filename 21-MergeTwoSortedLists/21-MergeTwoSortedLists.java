// Last updated: 6/18/2025, 8:25:42 PM
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if (list1 == null && list2 == null) {
            // Edge case #1 - [] []
            return null;
        } else if (list1 == null && (list2 != null)) {
            // Edge case #2 - [] [0]
            return list2;
        } else if (list2 == null && (list1 != null)) {
            // Edge case #3 - [1] []
            return list1;
        }

        
        ListNode resNode = new ListNode(0, null);
        ListNode newHead = resNode;

        while (true) {
            if (list1.val <= list2.val) {
                resNode.next = new ListNode(list1.val);
                list1 = list1.next;
            } else if (list2.val < list1.val) {
                resNode.next = new ListNode(list2.val);
                list2 = list2.next;
            }

            resNode = resNode.next;

            if (list1 == null && list2 != null) {
                resNode.next = list2;
                break;
            } else if  (list1 != null && list2 == null) {
                resNode.next = list1;
                break;
            }

        }

        return newHead.next;

    }
}