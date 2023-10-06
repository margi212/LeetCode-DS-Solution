class Solution {
    public int integerBreak(int n) {
        if(n==3){
            return 2;
        }
        
        if(n==1 || n==2){
            return 1;
        }
        
        int[][] dp = new int[n+1][n+1];
        
        for (int[] row: dp)
            Arrays.fill(row, -1);
        return helper(1, n, dp);
    }
    
    private int helper(int i,int n, int[][] dp){
        if(n==0){
            return 1;
        }
        if(i>n||i<=0){
            return 0;
        }
        
        if(dp[i][n]!=-1){
            return dp[i][n];
        }
        
        int pick = i * helper(i,n-i,dp);
        int notPick = helper(i+1,n,dp);
        
        return dp[i][n] = Math.max(pick,notPick);
    }
}