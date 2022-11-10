//{ Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Pair{
    Node node;
    int horizontalDistance;
    Pair(Node node,int horizontalDistance){
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }
}

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>(); 
        
        if(root == null) return ans;
        
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0)); 
        
        while(!q.isEmpty()) {
            Pair it = q.remove();
            int hd = it.horizontalDistance; 
            Node temp = it.node; 
            
            if(!map.containsKey(hd)){
                map.put(hd, temp.data); 
            }
            
            if(temp.left != null) {
                q.add(new Pair(temp.left, hd - 1)); 
            }
            
            if(temp.right != null) {
                q.add(new Pair(temp.right, hd + 1)); 
            }
        }
    
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
    
        return ans; 
        
        // HashMap<Integer,Integer> map = new HashMap<>();
        // ArrayList<Integer> ans = new ArrayList<>();
        
        // int[] values = {10000000,-10000000};
        // traverseTop(root,0,map,values);
        
        // int minVal = values[0];
        // int maxVal = values[1];
        // for(int i=minVal;i<=maxVal;i++){
        //     ans.add(map.get(i));
        // }
        // return ans;
    }
    
    private static void traverseTop(Node root,int horizDist,HashMap<Integer,Integer> map,int[] values){
        if(root==null)
            return;
       
        if(!map.containsKey(horizDist)){
            values[0] = Math.min(horizDist,values[0]);
            values[1] = Math.max(horizDist,values[1]);
            map.put(horizDist,root.data);
        }
        
        traverseTop(root.left,horizDist-1,map,values);
        traverseTop(root.right,horizDist+1,map,values);
        
    }
}