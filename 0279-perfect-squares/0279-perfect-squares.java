class Solution {
    public int numSquares(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return helper(n,map);
    }
    
    private int helper(int n, HashMap<Integer,Integer> map){
        if(n<0){
            return Integer.MAX_VALUE;
        }
        
        if(n==0)
            return 0;
        
        if(map.containsKey(n)){
            return map.get(n);
        }
        
        int min = n;
        
        for(int i=1;i*i<=n;i++){
            min = Math.min(min,helper(n-(i*i),map));
        }
        
        map.put(n,min+1);
        //System.out.println(n+":"+(min+1));
        return min+1;
    }
}