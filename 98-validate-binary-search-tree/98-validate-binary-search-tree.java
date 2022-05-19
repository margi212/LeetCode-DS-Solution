/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) { 
//approach-1(using inorder)
//         List<Integer> list = inOrder(root,new ArrayList<Integer>());
//         Object[] objectAarray = list.toArray();
//         int length = objectAarray.length;;
//         int [] intArray = new int[length];
//         for(int i =0; i < length; i++) {
//             intArray[i] = (int) objectAarray[i];
//         }        
//         return isSorted(intArray);
 
//approach-2(using recursion)
        return recursive(root,Long.MIN_VALUE,Long.MAX_VALUE);
        
//approach-3(using lleft max and right max)
    }
    
    private List<Integer> inOrder(TreeNode root,List<Integer> val) {
        if(root !=  null) {
            inOrder(root.left,val);
            val.add(root.val);
            inOrder(root.right,val);
        }        
        return val;
    }
    
     private boolean isSorted(int[] a) {
        // base case
        if (a == null || a.length <= 1) {
            return true;
        }
 
        for (int i = 0; i < a.length - 1; i++){
            if (a[i] >= a[i + 1]) {
                return false;
            }
        }
 
        return true;
    }
    
    private boolean recursive(TreeNode root,long left,long right){
        if(root == null)
            return true;
        
        if(root.val>=right || root.val<=left)
            return false;
        
        return recursive(root.right,root.val,right) && recursive(root.left,left,root.val);
    }
}