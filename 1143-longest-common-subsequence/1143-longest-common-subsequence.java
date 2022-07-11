class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
          return lengthLCS(text1,text2,0,0,text1.length(),text2.length(),new HashMap<String,Integer>());
    }
    
    private int lengthLCS(String str1,String str2,int i,int j,int m,int n,HashMap<String,Integer> memo){
        if(i>=m ||j>=n)
            return 0;
        
        String key = i+"-"+j;
        if(memo.containsKey(key))
            return memo.get(key);
        
        int ans = 0;
        if(str1.charAt(i)==str2.charAt(j)){
            ans = 1+lengthLCS(str1,str2,i+1,j+1,m,n,memo);
        }else{
            int a = lengthLCS(str1,str2,i,j+1,m,n,memo);
            int b = lengthLCS(str1,str2,i+1,j,m,n,memo);
            ans = Math.max(a,b);
        }
        
        memo.put(key,ans);
        return ans;
    }
}