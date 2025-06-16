// Last updated: 6/15/2025, 10:56:26 PM
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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        ListNode pointer = head;
        while (pointer != null) {
            list.add(pointer.val);

            pointer = head.next;
            head = pointer;
        }

        
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left ++;
            right --;
        }

        return true;
    }
}