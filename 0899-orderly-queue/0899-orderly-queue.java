class Solution {
    public String orderlyQueue(String s, int k) {
        String ans = s;
        
        if(k>1){
            char[] ch = ans.toCharArray();
            Arrays.sort(ch);
            ans = new String(ch);
        }else{
            //k==1
            //only one swap for each char
            for(int i=0;i<s.length();i++){
                String temp = s.substring(i) + s.substring(0,i);
                
                if(ans.compareTo(temp)>0){
                    ans = temp;
                }
            }
        }
        
        return ans;
    }
}