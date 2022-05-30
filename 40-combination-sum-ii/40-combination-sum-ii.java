class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        generateComb(candidates,0,target,new ArrayList<Integer>(),ans);        
        return ans;
    }
    
    private void generateComb(int[] nums,int ci,int target,List<Integer> current,List<List<Integer>> ans){
        
        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }
        
        if(ci>=nums.length){
            return;
        }
        
        if(nums[ci]<=target){
            current.add(nums[ci]);
            //consider
            generateComb(nums,ci+1,target-nums[ci],current,ans);
            //backtracking
            current.remove(current.size()-1);
        }
        
        // skip the repated element and going to unique elements
        while(ci+1<nums.length && nums[ci]==nums[ci+1]) ci++;
  
        //not-consider
        generateComb(nums,ci+1,target,current,ans);
        return;       
    }
        
}