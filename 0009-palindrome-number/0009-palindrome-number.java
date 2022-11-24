class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        
        int count = s.length()/2;
        for (int i=0; i< count ; i++){
            if(Character.compare(s.charAt(i), s.charAt(s.length()-1-i) )!=0 ){
                return false;
            }
        }

        return true;
    }
}