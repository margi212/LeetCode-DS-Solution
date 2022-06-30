class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        
        int firstPosition = findFirstPosition(nums, target);
        
        if(firstPosition == -1)
            return result;
        
        int lastPosition = findLastPosition(nums, target);
        
        for(int i = firstPosition; i <= lastPosition; i++)
            result.add(i);
        
        return result;
    }
    
    private int findFirstPosition(int[] nums, int target){
        int answerIndex = -1;
        
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            //comparison & decision both
            if(nums[mid] == target){
                answerIndex = mid;
                end = mid-1;
            }//decision
            else if(nums[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        
        return answerIndex;
    }
    
    private int findLastPosition(int[] nums, int target){
        int answerIndex = -1;
        
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            //comparison & decision both
            if(nums[mid] == target){
                answerIndex = mid;
                start = mid+1;
            }//decision
            else if(nums[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        
        return answerIndex;
    }
}