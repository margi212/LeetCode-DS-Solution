class Solution {
    public boolean isMonotonic(int[] nums) {
        
        int diff = nums[nums.length-1] - nums[0];
        
        for(int i = 1; i < nums.length; i++){
            
           if((diff <= 0 && nums[i] - nums[i-1]>0) || (diff >= 0 && nums[i]-nums[i-1]<0)){
               return false;
           }
        
        }
        return true;
    }
}