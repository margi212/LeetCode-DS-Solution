class Solution {
    public boolean canJump(int[] nums) {
       // return isJumpable(nums,0,new HashMap<Integer,Boolean>());
        int n=nums.length;
        int temp=0;
        for(int i=0;i<n;i++){
            if(temp<i) return false;
            temp=Math.max(temp,i+nums[i]);
        }
        return true;
    }
                          
    private boolean isJumpable(int[] nums,int ci,HashMap<Integer,Boolean> memo){
        
        if(ci>=(nums.length-1))
            return true;
     
        int key = ci;
        if(memo.containsKey(ci))
            return memo.get(ci);
           
        int currentJump=nums[ci];
        boolean ans = false;
        
        for(int i=1;i<=currentJump;i++){
           boolean tempAns = isJumpable(nums,ci+i,memo);
            ans = ans||tempAns;
         
        }
          
        memo.put(ci,ans);
        return ans;
    }
}