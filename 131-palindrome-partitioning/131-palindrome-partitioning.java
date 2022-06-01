class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        callPartition(0,s.length()-1,s,new ArrayList<String>(),ans);
        return ans;
    }
    
    private void callPartition(int si,int ei,String s,List<String> str,List<List<String>> result){
        
        if(si>ei){
            result.add(new ArrayList<String>(str));
            return;
        }
        
        for(int i=si;i<=ei;i++){
            String left = s.substring(si,i+1);
            
            if(isPalindrom(left)){
                str.add(left);
                callPartition(i+1,ei,s,str,result);
                str.remove(str.size()-1);
            }
            
        }
    }
    
    private boolean isPalindrom(String str){
        int i = 0;
        int j = str.length()-1;
        while (i < j) {
           if (str.charAt(i) != str.charAt(j))
                return false;
        
            i++;
            j--;
        }
        return true;
    }
}