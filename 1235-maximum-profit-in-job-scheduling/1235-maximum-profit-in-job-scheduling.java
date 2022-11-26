class Job{
    int startTime;
    int endTime;
    int profit;
    
    Job(int startTime,int endTime,int profit){
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[] dp = new int[n];
        Job[] jobs = new Job[n];
        
        for(int i=0;i<n;i++){
            jobs[i] = new Job(startTime[i],endTime[i],profit[i]);
            dp[i] = -1;
        }
        
        //if both start time eq then sort according to end time
        Arrays.sort(jobs,(a,b)->a.startTime==b.startTime?a.endTime-b.endTime:a.startTime-b.startTime);
    
        return helper(jobs,dp,0);
    }
    
    private int helper(Job[] jobs, int[] dp, int i){
        if(i>=jobs.length)
            return 0;
        
        if(dp[i]!=-1)
            return dp[i];
        
        int j = i+1;
        
         // Find the next job that can be scheduled, this will be a job with start time strictly greater than the end time of current job
        while(j<jobs.length && jobs[j].startTime<jobs[i].endTime){
           j++;
        }
        
        dp[i] = Math.max(helper(jobs,dp,j)+jobs[i].profit, helper(jobs,dp,i+1));
        
        return dp[i];
    }
}