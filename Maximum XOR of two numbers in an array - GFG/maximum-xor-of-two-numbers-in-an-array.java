//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[n];
            for(int i = 0; i < n; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
           System.out.println(ob.max_xor(v, n));
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Node{
    Node[] links = new Node[2];
    
    public Node(){
    }
    
    boolean containsKey(int node){
        return links[node]!=null;
    }
    
    Node getNode(int node){
        return links[node];
    }
    
    void put(Node node,int val){
        links[val] = node; 
    }
}

class Trie{
    Node root;
    
    Trie(){
        root = new Node();
    }
    
    public void insert(int num){
        Node node = root;
        for(int i=31;i>=0;i--){
            int bit = (num>>i) & 1;
            
            if(!node.containsKey(bit)){
                node.put(new Node(),bit);
            }
            
            node = node.getNode(bit);
        }
    }
    
    public int getMax(int num){
        Node node = root;
        int max = 0;
        
        for(int i=31;i>=0;i--){
            int bit = (num>>i) & 1;
            
            if(node.containsKey(1-bit)){
                max = max | 1<<i;
                node = node.getNode(1-bit);
            }else{
                node = node.getNode(bit);
            }
        }
        
        return max;
    }
}

class Solution {
    
    public static int max_xor(int nums[], int n) {
        int res = 0;
        
        Trie trie = new Trie();
        for(int num:nums){
            trie.insert(num);
            res = Math.max(res,trie.getMax(num));
        }
        
        return res;
    }
}