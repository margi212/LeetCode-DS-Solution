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
    public List<Integer> rightSideView(TreeNode root) {
        return rightList(root,1,new ArrayList<Integer>());
    }
    
    private List<Integer> rightList(TreeNode root,int level,List<Integer> ans){
        
        if(root==null)
            return ans;
        
        if(ans.size()<level)
            ans.add(root.val);
        
            rightList(root.right,level+1,ans);
            rightList(root.left,level+1,ans);
        
        return ans;
    }
}