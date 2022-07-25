class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        
        if(n==1)
            return nums[0];
        
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        
        for(int i=0;i<n;i++){
            if(i!=0){
                temp1[i] = nums[i];
            }
            if(i!=n-1){
                temp2[i] = nums[i];
            }
                
        }
         
        return Math.max(
            maxMoney(0,temp1,new HashMap<Integer,Integer>()),
            maxMoney(0,temp2,new HashMap<Integer,Integer>())
        );
    }
    
    public int maxMoney(int currentI,int[] nums,HashMap<Integer,Integer> memo){
        if(currentI>=nums.length)
            return 0;
        
        if(memo.containsKey(currentI))
            return memo.get(currentI);
        
        int result = Math.max(maxMoney(currentI+2,nums,memo)+nums[currentI],maxMoney(currentI+1,nums,memo));
    
        memo.put(currentI,result);
        return result;
    }
}