/* 
nums  :[1,2,3,4]
ans   :[1,1,2,6]
ri8prd: 24,12,4,1      
finAns:[24,12,8,6]
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        
        ans[0] = 1;
        for(int i=1;i<nums.length;i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        
        int rightPrd = 1;
        for(int i=nums.length-1;i>=0;i--){
            ans[i] = ans[i] * rightPrd; 
            rightPrd = rightPrd * nums[i];
        }
        
        return ans;
    }
}