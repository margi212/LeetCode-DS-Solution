class Solution {
    public int findMin(int[] nums) {
        int res = nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<res)
                res = nums[i];
        }
        
        return res;

    }
}