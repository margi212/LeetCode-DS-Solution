class Solution {
    private int dfs(int[][] grid, int row, int col, int k, int[][][] dp, boolean[][] visited) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col]) {
			return Integer.MAX_VALUE;
		}
		if (row == 0 && col == 0) {
			return 0;
		}
		if (dp[row][col][k] != Integer.MAX_VALUE) {
			return dp[row][col][k];
		}
		// Manhattan optimization
        // from https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/discuss/2054300/BFS-is-for-losers.-Legends-make-DFS-work
		if (k >= row + col) {
			return dp[row][col][k] = row + col;
		}
		if (grid[row][col] == 1 && --k < 0) {
			return Integer.MAX_VALUE;
		}

		visited[row][col] = true;
		int minWays = Integer.MAX_VALUE;
        minWays = Math.min(dfs(grid, row - 1, col, k, dp, visited), minWays);
        minWays = Math.min(dfs(grid, row + 1, col, k, dp, visited), minWays);
		minWays = Math.min(dfs(grid, row, col - 1, k, dp, visited), minWays);
		minWays = Math.min(dfs(grid, row, col + 1, k, dp, visited), minWays);
		
		visited[row][col] = false;
		dp[row][col][k] = minWays == Integer.MAX_VALUE ? Integer.MAX_VALUE : minWays + 1;
		return dp[row][col][k];
	}

	public int shortestPath(int[][] grid, int k) {
		int[][][] dp = new int[grid.length][grid[0].length][k + 1];
		for (int[][] matrix : dp) {
			for (int[] row : matrix) {
				Arrays.fill(row, Integer.MAX_VALUE);
			}
		}
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int minWays = dfs(grid, grid.length - 1, grid[0].length - 1, k, dp, visited);
		return minWays == Integer.MAX_VALUE ? -1 : minWays;
	}
}