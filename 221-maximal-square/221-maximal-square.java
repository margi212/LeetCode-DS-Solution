class Solution {
    public int maximalSquare(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int ans = 0;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
      
        for(int cRow = 0; cRow < m; cRow++){
            for(int cCol = 0; cCol < n; cCol++){
                if(grid[cRow][cCol] == '1'){
                    int sideLength = maxSq(m,n,cRow,cCol,grid,map);
                    ans = Math.max(ans,sideLength * sideLength);
                }
            }
        }
        
        return ans;
    }
    
    private int maxSq(int m,int n, int cRow, int cCol, char[][] grid,HashMap<String,Integer> map){
        
        if(cRow<0 || cRow>=m || cCol<0 || cCol>=n || grid[cRow][cCol]=='0'){
            return 0;
        }
        
        String key = cRow+"-"+cCol;
        
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        int down = 1 + maxSq(m,n,cRow,cCol+1,grid,map);
        int right = 1 + maxSq(m,n,cRow+1,cCol,grid,map);
        int rightDown = 1 + maxSq(m,n,cRow+1,cCol+1,grid,map);
        
        map.put(key,Math.min(down,Math.min(right,rightDown)));
        return map.get(key);
    }
}