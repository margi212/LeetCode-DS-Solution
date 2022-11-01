class Solution {
    public int[] findBall(int[][] grid) {
        int totalRows = grid.length;//m
        int totalCols = grid[0].length;//n
        
        int[] ans = new int[totalCols];
        for(int i=0;i<totalCols;i++){
           ans[i] = dfs(grid,0,i,totalRows,totalCols);
        }
        
        return ans;
    }
    
    private int dfs(int[][] grid, int cRow, int cCol,int totalRows, int totalCols) {
        if(cRow==totalRows)
            return cCol;
        
        if((grid[cRow][cCol] == 1 && (cCol == grid[0].length - 1 || grid[cRow][cCol + 1] == -1)) || grid[cRow][cCol] == -1 && (cCol == 0 || grid[cRow][cCol - 1] == 1)){
            return -1;
        }
        
        if(grid[cRow][cCol]==1){
           return dfs(grid,cRow+1,cCol+1,totalRows,totalCols);
        }else{
            return dfs(grid,cRow+1,cCol-1,totalRows,totalCols);
        }
    }
  
}