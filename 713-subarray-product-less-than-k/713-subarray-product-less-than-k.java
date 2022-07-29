class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0;
        int j = 0;
        
        int mul = 1;
        int ans = 0;
        
        while(j<nums.length){
            mul = mul * nums[j];
            
            while(mul>=k && i<=j){
                mul = mul/nums[i];
                i++; 
            }
            
            ans = ans +(j-i+1);
            j++;
        }
        
        return ans;
    }
}