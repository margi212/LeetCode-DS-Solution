//https://www.youtube.com/watch?v=Q8LhG9Pi5KM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=7
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
    public int[] maximizeXor(int[] arr, int[][] queries) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<>();
        int m = queries.length;
        
        for(int i=0;i<m;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(queries[i][1]);
            temp.add(queries[i][0]);
            temp.add(i);
            offlineQueries.add(temp);
        }
        
        Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a,ArrayList<Integer> b){
                return a.get(0).compareTo(b.get(0));
            }        
        });
        
        int ind = 0;
        int n = arr.length;
        
        Trie trie = new Trie();
        ArrayList<Integer> ans = new ArrayList<Integer>(n);
        for(int i=0;i<m;i++){
            ans.add(-1);
        }
        
        //O(Q+N)
        for(int i=0;i<m;i++){
            while(ind<n && arr[ind]<=offlineQueries.get(i).get(0)){
                trie.insert(arr[ind]);
                ind++;
            }
            
            int qryInd = offlineQueries.get(i).get(2);
            if(ind != 0){
                ans.set(qryInd,trie.getMax(offlineQueries.get(i).get(1)));
            } else{
                ans.set(qryInd,-1);
            }
        }
        
        return ans.stream().mapToInt(i->i).toArray();
    }
}