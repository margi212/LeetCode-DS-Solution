class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        
        int left = 0;
        //int right = s.length() - 1;
        
        int ans = 0;
        int k = 1;
        for(int right =0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left= left+1;
            }
            
            set.add(s.charAt(right));
            k = right - left + 1;
            
            ans = Math.max(k,ans);
        }
        
        return ans;
    }
}