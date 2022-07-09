class Solution {
    public int uniquePaths(int m, int n) {
        HashMap<String,Integer> map = new HashMap<>();
        return getPaths(m,n,0,0,map);
    }
    
    private int getPaths(int m,int n,int cRow,int cCol, HashMap<String,Integer> map){
        if(cRow>=m || cCol>=n)
            return 0;
        
        if(cRow==m-1 && cCol==n-1){
            return 1;
        }
        
        String key = cRow+"-"+cCol;
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        int ans = getPaths(m,n,cRow,cCol+1,map) + getPaths(m,n,cRow+1,cCol,map);
        map.put(key,ans);
        return ans;
    }
}