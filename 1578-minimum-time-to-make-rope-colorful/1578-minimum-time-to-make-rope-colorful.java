class Solution {
    public int minCost(String colors, int[] neededTime) {
     
        int result = 0;
        int prevCost = neededTime[0];
        
        for(int i=1;i<colors.length();i++){
            if(colors.charAt(i) == colors.charAt(i-1)){
                result += Math.min(prevCost,neededTime[i]);
                prevCost = Math.max(prevCost,neededTime[i]);
            }else{
                prevCost = neededTime[i];
            }
        }
        return result;
    }
}