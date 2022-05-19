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
    public TreeNode buildTree(int[] inorder,int[] postorder) {
        int postIndex[] ={postorder.length-1};
        return getTree(postorder,inorder,postIndex,0,inorder.length-1);
    }
    
 private TreeNode getTree(int[] postorder, int[] inorder,int[] postIndex,int inStart,int inEnd){
       
        if(inStart>inEnd || postIndex[0]>=postorder.length)
            return null;
        
        int cVal = postorder[postIndex[0]];
        TreeNode cNode = new TreeNode(cVal);
        
        postIndex[0]-=1;
        
        int i = getInorder(cVal,inorder);
        cNode.right = getTree(postorder,inorder,postIndex,i+1,inEnd);
        cNode.left = getTree(postorder,inorder,postIndex,inStart,i-1);
        
        return cNode;
    }
    
    private int getInorder(int num, int[] inorder) {
        for(int j=0;j<inorder.length;j++){
           if(inorder[j]==num){
               return j;
           }
        }
        return 0;
    }
       
}