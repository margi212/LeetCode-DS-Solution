class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        
        getSubsets(nums,0,new ArrayList<Integer>(),res);
        
        return new ArrayList<>(res);
    }
    
    private void getSubsets(int[] nums ,int ci, List<Integer> subset,HashSet<List<Integer>> res) {
        
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
    
    }
    
}