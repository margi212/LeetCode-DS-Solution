class Node{
    Node[] links = new Node[2];
    
    Node(){
            
    }
    
    public boolean isContainsKey(int num){
        return links[num]!=null;
    }
    
    public void put(int bit,Node node){
        links[bit] = node;
    }
    
    public Node getNode(int bit){
        return links[bit];
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
            if(!node.isContainsKey(bit)){
                node.put(bit,new Node());
            }
            
            node = node.getNode(bit);
        }    
    }
    
    public int getMax(int num){
        Node node = root;
        int max = 0;
        
        for(int i=31;i>=0;i--){///
            int bit = (num>>i) & 1;
            if(node.isContainsKey(1-bit)){
                max = (max | 1<<i);
                node = node.getNode(1-bit);
            }else{
                node = node.getNode(bit);    
            }
            
        } 
        
        return max;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        
        Trie t = new Trie();
        for(int num:nums){
            t.insert(num);
            res = Math.max(t.getMax(num),res);
        }
        
        return res;
    }
}