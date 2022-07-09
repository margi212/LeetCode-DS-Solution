class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int ans = 10001;
        
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int cCol=0;cCol<n;cCol++){
            int tempAns = minSum(m,n,0,cCol,grid,map);
            ans = Math.min(ans,tempAns);
        }
        
        return ans;    
    }
    
    private int minSum(int m,int n,int cRow,int cCol,int[][] grid,HashMap<String,Integer> map){
        if(cCol<0 || cCol>=n){
            return 10001;
        }
        
        if(cRow == m-1){
            return grid[cRow][cCol];
        }
        
        String key = cRow+"-"+cCol;
        
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        int leftDiag = grid[cRow][cCol] + minSum(m,n,cRow+1,cCol-1,grid,map);
        int downDiag = grid[cRow][cCol] + minSum(m,n,cRow+1,cCol,grid,map);
        int rightDiag = grid[cRow][cCol] + minSum(m,n,cRow+1,cCol+1,grid,map);
        
        int ans = Math.min(leftDiag,Math.min(downDiag,rightDiag));
        map.put(key,ans);
        return ans;
    }
    
}