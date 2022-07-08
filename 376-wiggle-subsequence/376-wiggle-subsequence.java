class Solution {
    public int wiggleMaxLength(int[] nums) {
       if(nums.length<2)
           return nums.length;
        
        int prv = nums[1]-nums[0];
        
        int count = prv!=0?2:1;
        for(int i=2;i<nums.length;i++){
            int diff=nums[i]-nums[i-1];
            
            if((diff>0&&prv<=0)||(diff<0&&prv>=0)){
                count++;
                prv=diff;
            }
        }
        
        return  count;
    }
}