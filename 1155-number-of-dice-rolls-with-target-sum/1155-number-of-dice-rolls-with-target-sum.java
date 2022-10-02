class Solution {
    public int numRollsToTarget(int n, int f, int target) {
        return countDice(n,f,target,0,new HashMap<String,Integer>());
    }
    
    private int countDice(int dice,int faces, int targetSum,int ci, HashMap<String,Integer> map){
        if(targetSum == 0 && dice==0)
            return 1;
        
        if(targetSum<0 || dice<=0)
            return 0;
        
        int totalWays = 0;
        
        String key = dice+"-"+targetSum;
        
        if(map.containsKey(key))
            return map.get(key);
        
        //(a+b)%c = (a%/c + b%c) %c
        int mod = 1000000007;
        for(int i=1;i<=faces;i++){
            int temp = countDice(dice-1,faces,targetSum-i,i,map)%mod;
            totalWays = totalWays % mod;
            totalWays = (totalWays + temp ) % mod;
        }
                
        map.put(key,totalWays);
        return totalWays;
    }
}
