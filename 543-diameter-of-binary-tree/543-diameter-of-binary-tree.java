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
    int d = 0;
        
    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return d;
    }
    
    private int getDiameter(TreeNode root){
        if(root==null)
            return 0;
        
        int leftAns = getDiameter(root.left);
        int rightAns = getDiameter(root.right);
        
        d = Math.max(d,(leftAns + rightAns));
        return (Math.max(leftAns,rightAns) + 1);
    }    
}
