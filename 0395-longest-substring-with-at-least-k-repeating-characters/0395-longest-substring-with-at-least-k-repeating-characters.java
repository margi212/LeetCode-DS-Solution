class Solution {
    public int longestSubstring(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        int ans = 0;
        while(ans < s.length() && map.get(s.charAt(ans)) >= k){
            ans++;
        }

        if(ans == s.length()){
            return ans;
        }
        
        int left = longestSubstring(s.substring(0,ans),k);
        int right = longestSubstring(s.substring(ans+1),k);

        return Math.max(left,right);
    }
}