class Solution {
    public int findPeakElement(int[] nums) {
        int res = nums[0];
        
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>res){
                res = nums[i];
                index = i;
            }
        }
        
        return index;

    }
}