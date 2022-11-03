class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int maxLen = 0;

        for (String s : words) {
            String rev = "" + s.charAt(1) + s.charAt(0);
        
            if (map.containsKey(rev) && map.get(rev) > 0) { // if we find reverse s prev . 
                maxLen += 4;
                map.put(rev, map.get(rev) - 1);
            } else {
                int freq = map.getOrDefault(s, 0) + 1;
                map.put(s, freq);
            }

        }

        for (String s : map.keySet()) {
            if (map.get(s) > 0 && s.charAt(1) == s.charAt(0)) {
                maxLen += 2;
                break;
            }
        }

        return maxLen;  
    }
}