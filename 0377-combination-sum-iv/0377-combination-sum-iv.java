class Solution {
    public int combinationSum4(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        return count(nums,target,map);
    }
    
    private int count(int[] nums,int target,HashMap<Integer, Integer> map) {
        if (map.containsKey(target)) 
            return map.get(target);
      
        if(target<0)
            return 0;
        
        if(target==0)
            return 1;
    
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res += count(nums,target-nums[i],map);
        }
        
        map.put(target, res);
    
        return res;
    }
}