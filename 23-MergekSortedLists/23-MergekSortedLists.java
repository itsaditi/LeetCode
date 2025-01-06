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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode node: lists) {
            if (node != null) minHeap.add(node);
        }

        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (!minHeap.isEmpty()) {
            ListNode poppedNode = minHeap.poll();

            curr.next = poppedNode;
            curr = poppedNode;

            if (poppedNode.next != null) {
                minHeap.add(poppedNode.next);
            }
        }

        return head.next;
    }
}