class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        getList(n,0,0,"",ans);
        return ans;
    }
    
    public void getList(int n,int op,int cl,String str,List<String> ans){
        if(op>n||cl>n)
            return;
        if(op == n && cl == n){
            ans.add(str);
            return;
        }
        
        //left call
        getList(n,op+1,cl,str+"(",ans);
        
        if(op>cl){
            //right call
            getList(n,op,cl+1,str+")",ans);
        }
    }
}