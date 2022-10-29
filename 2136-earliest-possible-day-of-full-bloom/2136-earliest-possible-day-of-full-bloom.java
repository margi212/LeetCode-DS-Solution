class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        // https://leetcode.com/problems/earliest-possible-day-of-full-bloom/discuss/2754482/Java-oror-Explained-in-Detailoror-Simple-and-Fast-Solutionoror-Greedy-%2B-Sorting
        
        int n = plantTime.length;
        
        Pair[] flowerTime = new Pair[n];
        
        for(int i=0;i<n;i++){
            flowerTime[i] = new Pair(plantTime[i],growTime[i]);
        }
        
        Arrays.sort(flowerTime,(a,b) -> b.growTime-a.growTime);
        
        int plantingDays = 0;
        int totalDays = 0;
        
        for (Pair current : flowerTime) {
            totalDays = Math.max(totalDays,current.plantTime+current.growTime+plantingDays);
            plantingDays = plantingDays+current.plantTime;
        }
        return totalDays;
    }
    
    class Pair{
        int plantTime;
        int growTime;
        Pair(int plantTime,int growTime){
            this.plantTime = plantTime;
            this.growTime = growTime;
        }
    }
}