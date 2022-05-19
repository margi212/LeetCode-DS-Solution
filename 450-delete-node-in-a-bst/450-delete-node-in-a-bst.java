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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        
        if(root.val>key){
            root.left = deleteNode(root.left,key); 
        }
        
        else if(root.val<key){
            root.right = deleteNode(root.right,key);
        }
        
        else{
            //case-1:No child
            if(root.left==null&&root.right==null){
                root=null;
                return null;
            }

            //case-2:single child
            else if(root.left!=null&&root.right==null){
                root = root.left;
                return root;
            }

            else if(root.left==null&&root.right!=null){
                root = root.right;
                return root;
            }

            //case-3: Both child
            TreeNode successMinNode = findMinSuccesser(root.right);
           
            int temp = 0;
            temp = root.val;
            root.val = successMinNode.val;
            successMinNode.val = temp;
            
            root.right = deleteNode(root.right,key);
            
        }
        
        return root;
    }
    
    private TreeNode findMinSuccesser(TreeNode current) {
        while(current.left!=null){
            current = current.left;
        }
        
        return current;
    }
}