class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        HashMap<String,Integer> map = new HashMap<>();
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return getPaths(m,n,0,0,obstacleGrid,map);
    }
    
    private int getPaths(int m,int n,int cRow,int cCol, int[][] obstacleGrid,HashMap<String,Integer> map){
        if(cRow>=m || cCol>=n || obstacleGrid[cRow][cCol] == 1)
            return 0;
        
        if(cRow==m-1 && cCol==n-1){
            return 1;
        }
        
        String key = cRow+"-"+cCol;
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        int rightMove = getPaths(m,n,cRow,cCol+1,obstacleGrid,map);
        int downMove = getPaths(m,n,cRow+1,cCol,obstacleGrid,map);
        int ans = rightMove + downMove;
        
        map.put(key,ans);
        
        return ans;
    }
}