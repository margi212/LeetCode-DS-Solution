class Solution {
    public String longestPalindrome(String s) { String res = "";
        int resLen = 0;
            
        for (int i=0; i<=s.length(); i++) {
            
            // Odd Length
            int left = i;
            int right = i;
            
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if ((right - left + 1) > resLen) {
                    res = s.substring(left, right+1);
                    resLen = right - left + 1;
                }
                left -= 1;
                right += 1;
            }
            
            // Even Length
            left = i;
            right = i+1;
            
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if ((right - left + 1) > resLen) {
                    res = s.substring(left, right+1);
                    resLen = right - left + 1;
                }
                left -= 1;
                right += 1;
            }
        }
        return res;
    }
}