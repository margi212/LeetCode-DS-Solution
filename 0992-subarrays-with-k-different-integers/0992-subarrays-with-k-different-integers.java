class Solution {
    /*Well, suppose you have a room with a bunch of children in it. It turns out that there are 12 children who are five years old or under, and 8 children who are four years old or under.

Now presumably you agree that each one of the "children four years old or under" is also one of the "children five years old or under," right?

So suppose we take the 12 children five years old or younger, and remove from them the 8 children four years old or younger. Of course, 12 - 8 = 4 children remain.*/


    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    
    public int atMost(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int ans = 0;
        
        while(right<nums.length){
            int num = nums[right];
            
            map.put(num,map.getOrDefault(num,0)+1);            
            
            while(map.size()>k){
                int cNum = nums[left];
                if(map.containsKey(cNum)){
                    map.put(cNum,map.get(cNum)-1);
                    if(map.get(cNum)==0){
                        map.remove(cNum);                            
                    }
                }

                left++;
            }   

            ans = ans+(right-left+1);
            right++;
        }
        
        return ans;
    }
}