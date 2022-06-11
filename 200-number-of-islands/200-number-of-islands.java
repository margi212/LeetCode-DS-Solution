class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int cRow = 0; cRow < m; cRow++){
            for(int cCol = 0; cCol < n; cCol++){
                if(grid[cRow][cCol] == '1'){
                    callDfs(grid,cRow,cCol,m,n);
                    count += 1;
                }                    
            }    
        }
        return count;        
    }
    
    private void callDfs(char[][] grid,int cRow,int cCol,int m,int n){
        if(cRow < 0 || cRow >= m || cCol < 0  || cCol >= n || grid[cRow][cCol] == '0')
            return;
        
        grid[cRow][cCol] = '0';
        
        callDfs(grid,cRow-1,cCol,m,n);
        callDfs(grid,cRow+1,cCol,m,n);
        callDfs(grid,cRow,cCol-1,m,n);
        callDfs(grid,cRow,cCol+1,m,n);
        
        return;
    }
     
}