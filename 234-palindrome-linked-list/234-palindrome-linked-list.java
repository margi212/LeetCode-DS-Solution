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
        if(head == null || head.next == null)
            return true;
        
        ListNode mid = middleNode(head);
        
        ListNode rightHalf = mid.next;
        
        mid.next = null;
        
        ListNode leftHalf = head;
        return compare(leftHalf,reverseList(rightHalf,null));
    }
    
    private boolean compare(ListNode left,ListNode right){
        ListNode l1 = left;
        ListNode l2 = right;
        
        while(l1!=null &&l2!=null){
            if(l1.val!=l2.val)
                return false;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return true;
    }
    
    private ListNode reverseList(ListNode curr,ListNode prev){
        if(curr==null)
            return prev;
        
        ListNode newNode = curr.next;
        curr.next = prev;
        
        return reverseList(newNode,curr);
        
    }
    
    private ListNode middleNode(ListNode head) {
        if(head == null)
            return head;
        
        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}