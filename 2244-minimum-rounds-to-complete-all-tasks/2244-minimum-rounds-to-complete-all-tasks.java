class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> counterMap = new HashMap<>();
        for(int task:tasks){
            counterMap.put(task, counterMap.getOrDefault(task,0)+1);
        }
        
        int ans = 0;        
        for(Integer cVal : counterMap.values()){
            if(cVal==1){
                return -1;
            }
            if(cVal%3 == 0){
                ans += (cVal/3);
            }else{
                ans+= (cVal/3) + 1;
            }
        }        
        return ans;
    }
}