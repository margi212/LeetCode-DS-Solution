class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split("\\s+");
        
        for(int i = str.length - 1 ; i >= 0 ; i--){
            sb.append(str[i]);
            sb.append(" ");
        }
        
        return sb.toString().trim();
    }
}