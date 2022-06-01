class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        getList(n,0,0,"",ans);
        return ans;
    }
    
    public void getList(int n,int openCount,int closeCount,String currentStr,List<String> ans){
        if(openCount>n||closeCount>n)
            return;
        if(openCount == n && closeCount == n){
            ans.add(currentStr);
            return;
        }
        
        //left call
        getList(n,openCount+1,closeCount,currentStr+"(",ans);
        
        if(openCount>closeCount){
            //right call
            getList(n,openCount,closeCount+1,currentStr+")",ans);
        }
    }
}