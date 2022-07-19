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
    ListNode ans = null,current=ans;
      
    public ListNode deleteDuplicates(ListNode head) {
         
        Map<Integer,Integer> map=new LinkedHashMap<>();
        
        while(head != null){
            if(!map.containsKey(head.val)){
                map.put(head.val,1);
            }else {
                map.put(head.val,map.get(head.val)+1);
            }
            
            head = head.next;
        }
     
        map.forEach((k,v)->{
            if(v == 1){
                if(ans == null){
                    ans = new ListNode(k);
                    current = ans;
                }else{
                    current.next = new ListNode(k);
                    current = current.next;
                }
            }      
        });
        
        return ans;
    }
}