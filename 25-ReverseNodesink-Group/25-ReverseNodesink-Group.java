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
    public ListNode reverseKGroup(ListNode head, int k) {
        
     // size to match with K
     // create the dummy node to store the result
     // temp node to update dummy
     // Loop through list until end
            // if the current node size mathc with K than revers the list

        int size = 1;
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        ListNode temp = dummy;
        ListNode next = null; //to store the next remaining list

        while(curr != null){

            if(size == k){

                // store the remaining list
                next = curr.next;
                curr.next = null;
                
                // reverse the list
                ListNode newHead = reverse(head);

                // assignment for next iteration
                temp.next = newHead;
                temp = head; // put the pointer to the head of reverse list
                head = next;
                curr = next;
                size = 1;


            } else {
                curr = curr.next;
                size++;
            }
        }

        if(next != null){
            temp.next = next;
        }
        return dummy.next;

    }

    ListNode reverse(ListNode head){
    
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}