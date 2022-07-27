class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
       
        boolean[] visited = new boolean[nums.length];
         
        Arrays.fill(visited, Boolean.FALSE);
        dfs(nums,0,res,new ArrayList<>(),visited);
              
        return res;
    } 
    
    private void dfs(int[] nums,int ci,List<List<Integer>> res,List<Integer> subRes,boolean[] visited){
        
        if(ci==nums.length){
           res.add(new ArrayList<>(subRes));
           return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i] = true;
                subRes.add(nums[i]);
                dfs(nums,ci+1,res,subRes,visited);
                subRes.remove(subRes.size()-1);
                visited[i] = false;
            }
        }
    }
}