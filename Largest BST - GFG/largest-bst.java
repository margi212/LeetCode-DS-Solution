// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class SubTreeInfo{
    int size;
    int maxVal;
    int minVal;
    boolean isBST;
   
    SubTreeInfo(int size,int maxVal,int minVal,boolean isBST){
        this.maxVal = maxVal;
        this.minVal = minVal;
        this.size = size;
        this.isBST = isBST;
    }
    
    SubTreeInfo(int size,boolean isBST){
        this.size=size;
        this.isBST=isBST;
    }
}
class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root){
        return findLargestTree(root).size;
    }
    
    private static SubTreeInfo findLargestTree(Node root){
        if(root==null){
            return new SubTreeInfo(0,0,1000000,true);
        }
        
        if(root.left==null && root.right==null){
            return new SubTreeInfo(1,root.data,root.data,true);
        }
        
        SubTreeInfo leftAns = findLargestTree(root.left);
        SubTreeInfo rightAns = findLargestTree(root.right);
        
        if(leftAns.isBST&& rightAns.isBST && leftAns.maxVal<root.data && rightAns.minVal>root.data){
            int maxVal = Math.max(Math.max(leftAns.maxVal,rightAns.maxVal),root.data);
            int minVal = Math.min(Math.min(leftAns.minVal,rightAns.minVal),root.data);
            return new SubTreeInfo(leftAns.size+rightAns.size+1,maxVal,minVal,true);
        }else{
            return new SubTreeInfo(Math.max(leftAns.size,rightAns.size),0,0,false);
        }
    }
}