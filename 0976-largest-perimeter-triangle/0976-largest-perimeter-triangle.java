class Solution {
    public int largestPerimeter(int[] nums) {
        int result = 0;
        
        Arrays.sort(nums);
        for(int i = nums.length-1;i>1;i--){
            if(nums[i]<nums[i-2]+nums[i-1])
                return nums[i-2]+nums[i-1]+nums[i];
        }
        return result;
    }
}