class Solution {
    public int minDistance(String word1, String word2) {
        return minD(word1,word2,word1.length(),word2.length(),0,0,new HashMap<String,Integer>());
    }
    
    private int minD(String word1,String word2,int m,int n,int i,int j,HashMap<String,Integer> memo){ 
        
        if(j >= n)
            return m-i;
        
        if(i >= m)
            return n-j;
        
        String key = i+"-"+j;
        if(memo.containsKey(key))
            return memo.get(key);
        
        int ans = 1000001;
        if(word1.charAt(i) == word2.charAt(j)){
            ans = minD(word1,word2,m,n,i+1,j+1,memo);
        }else{
            int insert = 1 + minD(word1,word2,m,n,i,j+1,memo);
            int delete = 1 + minD(word1,word2,m,n,i+1,j,memo);
            int replace = 1 + minD(word1,word2,m,n,i+1,j+1,memo);
            
            ans = Math.min(insert,Math.min(delete,replace));
        }
        
        memo.put(key,ans);
        return ans;
    }
}