class Solution {
    public boolean isPalindrome(int x) {
//         String s = Integer.toString(x);
        
//         int count = s.length()/2;
//         for (int i=0; i< count ; i++){
//             if(Character.compare(s.charAt(i), s.charAt(s.length()-1-i) )!=0 ){
//                 return false;
//             }
//         }

//         return true;
        
        int temp = x;
        int reverse = 0;
        while(temp>0) {
            reverse = temp%10 + reverse*10;
            temp = temp/10;
        }
        return reverse==x?true:false;

    }
}