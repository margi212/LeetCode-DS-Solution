class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        int left =0, right =0, sum = 0, maxSum = 0;
        
        while(right<nums.length){
            int num = nums[right];
            
            while(set.contains(num)){
                int cNum = nums[left];
                sum = sum - cNum;
                set.remove(cNum);
                left++;
            }
            
            set.add(num);
            sum= sum+num;
            right++;
            
            maxSum = Math.max(sum,maxSum);
        }
        
        return maxSum;
    }
}