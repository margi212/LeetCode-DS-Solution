class Solution {
    public int minimumAverageDifference(int[] nums) {
        long leftSum = 0, rightSum = 0;
        
        for (int num : nums){
            rightSum = rightSum + num;
        }
        
        long minAbsolute=Integer.MAX_VALUE,index=nums.length;
        
        for(int i=0;i<nums.length;i++){
            leftSum = leftSum + nums[i];
            rightSum = rightSum - nums[i];
            long res = 0;
            long leftAvg = (leftSum)/(i+1);
            if(rightSum == 0){
                res = leftAvg;
            } else{
                long rightAvg = (rightSum)/(nums.length-1-i);
                res = Math.abs(leftAvg-rightAvg);
            }
            
            if(res<minAbsolute){
                minAbsolute=res;
                index=i;
            } else if(res==minAbsolute) {
                index=Math.min(index,i);
            }
        }
        return (int)index;
    }
}