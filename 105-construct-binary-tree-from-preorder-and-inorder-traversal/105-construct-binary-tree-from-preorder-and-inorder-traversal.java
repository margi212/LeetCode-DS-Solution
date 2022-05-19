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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preIndex[] ={0};
        return getTree(preorder,inorder,preIndex,0,inorder.length-1);
    }

    private TreeNode getTree(int[] preorder, int[] inorder,int[] preIndex,int inStart,int inEnd){
       
        if(inStart>inEnd || preIndex[0]>=preorder.length)
            return null;
        
        int cVal = preorder[preIndex[0]];
        TreeNode cNode = new TreeNode(cVal);
        
        preIndex[0]+=1;
        
        int i = getInorder(cVal,inorder);
        cNode.left = getTree(preorder,inorder,preIndex,inStart,i-1);
        cNode.right = getTree(preorder,inorder,preIndex,i+1,inEnd);
        
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