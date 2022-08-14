class Solution {
    public boolean isAnagram(String s, String t) {
        char []arr = s.toCharArray();
        Arrays.sort(arr);
        String m = String.valueOf(arr);
        
        char []rarr = t.toCharArray();
        Arrays.sort(rarr);
        String r = String.valueOf(rarr);
        
        return m.equals(r);
    }
}