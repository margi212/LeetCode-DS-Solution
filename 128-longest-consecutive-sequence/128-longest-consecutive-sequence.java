class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i]-1)){
                continue;
            }else{
                int count = 0;
                int current = nums[i];
                while(set.contains(current)){
                    count++;
                    current++;
                }
                ans = Math.max(ans,count);
            }
        }
        
        return ans;
    }
}