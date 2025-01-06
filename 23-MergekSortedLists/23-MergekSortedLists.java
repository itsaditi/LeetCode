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
    // O (n * log k) and O(k) where k is the lists.size()
    public ListNode mergeKLists(ListNode[] lists) {
          PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode node : lists){
            if(node != null)
                heap.add(node);
        }

        ListNode head = new ListNode(0);
        ListNode current = head;

        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                heap.add(node.next);
            }
        }
        
        return head.next;
    }
}