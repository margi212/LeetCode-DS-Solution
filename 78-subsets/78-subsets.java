class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> res = new ArrayList<List<Integer>>();
//         for(int i=0;i<nums.length;i++){
//             List<Integer> ai = new ArrayList<Integer>();
//             for(int j=0;j<=i;j++){
//                  ai.add(nums[j]);
//             }            
//             res.add(ai);          
            
//         }        
//         return res;
        
        getSubsets(nums,0,new ArrayList<Integer>(),res);
        
        return res;
    }
    
    private void getSubsets(int[] nums,int ci, List<Integer> subset,List<List<Integer>> res) {
        
        if(ci>=nums.length){
            res.add(new ArrayList<>(subset));
            return ;
        }
        
        //consider
        subset.add(nums[ci]);
        
        getSubsets(nums,ci+1,subset,res);
        
        //not-consider
        subset.remove(subset.size()-1);
        
        getSubsets(nums,ci+1,subset,res);
            
        return;
    }
    
}