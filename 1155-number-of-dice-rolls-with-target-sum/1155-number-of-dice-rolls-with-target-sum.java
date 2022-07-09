class Solution {
    public int numRollsToTarget(int n, int f, int target) {
        return countDice(n,f,target,new HashMap<String,Integer>());
    }
    
    private int countDice(int dice,int face,int targetSum,HashMap<String,Integer> map){
        if(targetSum == 0 && dice == 0)
            return 1;
        
        if(dice==0 || targetSum <= 0)
            return 0;
        
        String key = dice+"-"+targetSum;
        
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        int ways = 0;
        int MOD = 1000000007;
        //(a+b)%c = (a%c + b%c) %c
        
        for(int i = 1; i <= face; i++){
            int temp = countDice(dice-1,face,targetSum-i,map) % MOD;
            ways = ways % MOD;
            ways = (ways + temp) % MOD;
        }
       
        map.put(key,ways);
        return ways;
    }
}