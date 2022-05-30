class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
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
        
        // skip the repated element and going to unique elements
        while(ci+1<nums.length && nums[ci]==nums[ci+1]) ci++;
  
        getSubsets(nums,ci+1,subset,res);
            
        return;
    }
    
}