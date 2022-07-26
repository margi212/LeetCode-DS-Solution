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
    public int maxDepth(TreeNode root) {
        return calcHeight(root);
    }
    
    private int calcHeight(TreeNode root){
        if(root==null)
            return 0;
        
        int ans =0 ;
        int leftAns = 1+ calcHeight(root.left);
        int rightAns = 1+ calcHeight(root.right);
        
        return Math.max(leftAns,rightAns);
    }
}