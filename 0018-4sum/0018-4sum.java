class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        Set<List<Integer>> res = new HashSet<>();
        
        int n = nums.length;
      
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                int start = j+1;
                int end = nums.length-1;
                
                while(end>start) {
                    long sum = (long)(nums[i]+nums[j])+(long)(nums[start]+nums[end]);
                    
                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[start++], nums[end--]));
                    }else if(sum>target) {
                        end--;
                    }else {
                        start++;
                    }
                }
            }
        }
        
        return new ArrayList<>(res);	
    }
}