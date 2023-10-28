class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        for(int i[] :dp){
            Arrays.fill(i,-1);
        }
        return solve(m-1,n-1);
    }

    private int solve(int cRow,int cCol){
        if(cRow==0 || cCol==0){
            return 1;
        }

        if(dp[cRow][cCol]!=-1){
            return dp[cRow][cCol];
        }

        int left = solve(cRow,cCol-1);
        int up = solve(cRow-1,cCol);

        return dp[cRow][cCol] = left+up;
    }
}