class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int ans = Integer.MAX_VALUE;
        int cSum = 0;
        
        while(j<nums.length){
            
            cSum = cSum + nums[j];
            
            while(cSum >= target){
                ans = Math.min(ans,j-i+1); 
                cSum = cSum - nums[i];
                i++;
            }

            j++;
          
        }
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}