class Solution {
    public int minCut(String s) {
        return countCut(s,0,s.length()-1,new HashMap<String,Integer>());
    }
    
    private int countCut(String s,int si,int ei,HashMap<String,Integer> memo){
        if(isPalindrom(s,si,ei))
           return 0;
        
        int ans = 10001;
        String key = si+"-"+ei;
        if(memo.containsKey(key))
            return memo.get(key);
        
        for(int i=si;i<ei;i++){
            //String leftSub = s.subString(si,i);
            if(isPalindrom(s,si,i)){
                int temp = 1+countCut(s,i+1,ei,memo);
                ans = Math.min(ans,temp);
            }
        }
        
        memo.put(key,ans);
        return ans;
    }
    
    private boolean isPalindrom(String str,int i,int j){
         while (i < j) {
           if (str.charAt(i) != str.charAt(j))
                return false;
        
            i++;
            j--;
        }
        return true;
    }
}