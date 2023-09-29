class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int prefixSum = 0;
        for(int i = 0; i < nums.length; i++){
            
		    prefixSum += nums[i];
		    prefixSum %= k;
            
		    if(prefixSum == 0 && i > 0){
                return true;
            }
    	    if(map.containsKey(prefixSum) && i - map.get(prefixSum) > 1){
                return true;
            }
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, i);
            }            
        }
             
		return false;
    }
}