class Solution {
    public String reverseVowels(String s) {
        List<Character> list=Arrays.asList('a', 'e', 'i','o','u','A','E','I','O','U');

        char[] ch = s.toCharArray();
        
        int i = 0;
        int j = ch.length-1;
        
        while(i<j){
            if(list.contains(ch[i]) && list.contains(ch[j])) {
                char c = ch[i];
                ch[i] = ch[j];
                ch[j] = c;
                i++;
                j--;
            } else if(list.contains(ch[i]) && !list.contains(ch[j])) {
                j--;
            } else if(!list.contains(ch[i]) && list.contains(ch[j])) {
                i++;
            } else{
                i++;
                j--;
            }
        }
        
        String res = String.valueOf(ch);
        
        return res;
        
    }
}