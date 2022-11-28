class Solution {
    public int minimumCardPickup(int[] nums) {
        int ans = Integer.MAX_VALUE;        
        int right=0,left=0;
      
        Map<Integer,Integer> map = new HashMap<>();
        
        while(right<nums.length){
            int num = nums[right];            
            map.put(num,map.getOrDefault(num,0)+1);
            
            if(map.get(num)>1){
                while(map.containsKey(num) && map.get(num)>1){
                    int cNum = nums[left];
                    ans = Math.min(ans,right-left+1);
                    
                    map.put(cNum,map.get(cNum)-1);
                    
                    if(map.get(cNum)==0)
                        map.remove(cNum);                    
                    
                    left++;                    
                }
                
            }
            right++;
        }
        
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}