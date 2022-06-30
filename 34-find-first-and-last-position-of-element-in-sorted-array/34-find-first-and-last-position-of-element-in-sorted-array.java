class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        
        result[0] = getFirstPosition(nums,target);
        result[1] = getLastPosition(nums,target);
        
        return result;
    }
    
    private int getFirstPosition(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        
        int answerIndex = -1; 
        while(start<=end){
            int mid = start + ((end-start)/2);
            
            if(nums[mid] == target){
                answerIndex = mid;
                end = mid-1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return answerIndex;
    }
    
     private int getLastPosition(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        
        int answerIndex = -1; 
        while(start<=end){
            int mid = start + ((end-start)/2);
            
            if(nums[mid] == target){
                answerIndex = mid;
                start = mid + 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        
        return answerIndex;
    }
}