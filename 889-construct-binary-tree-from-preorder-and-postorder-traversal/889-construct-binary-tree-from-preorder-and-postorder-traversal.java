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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int size = preorder.length;
        return getTree(preorder,0,size-1,postorder,0,size-1);
    }

    private TreeNode getTree(int[] preorder, int preStartId,int preEndId,int[] postorder,int postStartId,int postEndId){
       
        if(preStartId>preEndId)
            return null;
        
        int cVal = preorder[preStartId];
        TreeNode cNode = new TreeNode(cVal);
        if(preStartId==preEndId)
            return cNode;
        
        int i = postStartId;
        while(postorder[i] != preorder[preStartId+1]) i++;
        
        int end = i-postStartId+1;
        
        cNode.left = getTree(preorder, preStartId+1, preStartId+end , postorder, postStartId, i  );
        cNode.right =  getTree(preorder,preStartId+end+1 , preEndId , postorder, i+1 , postEndId );
        
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