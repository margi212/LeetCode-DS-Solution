class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;
        
        for(int i=0;i<nums.length-1;i++){
            int cNum = nums[i];
            int nextNum = nums[i+1];
            if(cNum>nextNum){
                increasing = false;
            }
            
            if(cNum<nextNum){
                decreasing = false;
            }
        }
        
        return increasing || decreasing;
        
        
    }
}