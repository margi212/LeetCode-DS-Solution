class Solution {
    public int minMovesToMakePalindrome(String s) {
        char[] ch = s.toCharArray();
        
        int left = 0;
        int right = s.length()-1;
        
        int ans = 0;
        while(left<right){
            int k = right;
          
            if(ch[left] == ch[right]){
                left++;
                right--;
                continue;
            }
            
            while(ch[k] != ch[left]){
                k--;
            }
            
            if(left==k){
                 // means no swap element is present other than first index
                swap(ch,left,left+1);
                ans++;
            }else{
                while(k<right){
                    ans++;
                    swap(ch,k,k+1);
                    k++;
                }   
            }
        }
        
        return ans;
    }
    
    public static void swap(char arr[],int i,int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}