class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        
        for(String word: dictionary){
            set.add(word);
        }
        
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        
        return findMinExtraChar(0,s,set,dp);
        
    }
    
    private int findMinExtraChar(int cIndex, String s, Set<String> dictionary, int[] dp){
         // if index reached at the end of the string there no extra character remaining.
        if(cIndex>=s.length()){
            return 0;
        }
        
        // if dictionary contains word for subtring from index to length, there is no extra character.
        if (dictionary.contains(s.substring(cIndex, s.length()))){
            return 0;  
        }
        
        if (dp[cIndex] != Integer.MAX_VALUE) {
            return dp[cIndex];
        }
        
        int min = s.length() - cIndex;
        
        for(int i=cIndex+1;i<=s.length();i++){
            // if this substring is in dictionary there are zero characters.
            // else all characters of this substring are remaining.
            int count = dictionary.contains(s.substring(cIndex, i)) ? 0 : i - cIndex;
            // check for second half after split.
            count += findMinExtraChar(i,s, dictionary, dp);
            // updated the minimum value.
            min = Math.min(min, count);
        }
        
        // update dp[cIndex] with current min.
        dp[cIndex] = min;
        
        return min;
       
    }
}