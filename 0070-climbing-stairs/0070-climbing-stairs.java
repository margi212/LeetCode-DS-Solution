class Solution {
    public int climbStairs(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return climb(n,0, map);
    }
    
    private int climb(int n,int cIndex, HashMap<Integer,Integer> map){
        if(cIndex>n){
            return 0;
        }
        if(cIndex==n){
            return 1;
        }
        
        if(map.containsKey(cIndex)){
            return map.get(cIndex);
        }
        
        int ans = climb(n,cIndex+1,map)+climb(n,cIndex+2,map);
        map.put(cIndex,ans);
        return ans;
    }
}