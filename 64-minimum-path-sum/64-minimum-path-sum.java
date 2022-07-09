class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        return minSum(m,n,0,0,grid,map);   
    }
    
    private int minSum(int m,int n,int cRow,int cCol,int[][] grid,HashMap<String,Integer> map){
        if(cRow>=m || cCol>=n){
            return 10001;
        }
        
        if(cRow == m-1 && cCol == n-1){
            return grid[cRow][cCol] ;
        }
        
        String key = cRow+"-"+cCol;
        
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        int rightMove = grid[cRow][cCol] + minSum(m,n,cRow,cCol+1,grid,map);
        int downMove = grid[cRow][cCol] + minSum(m,n,cRow+1,cCol,grid,map);
        
        int ans = Math.min(rightMove,downMove);
        map.put(key,ans);
        return ans;
    }
}