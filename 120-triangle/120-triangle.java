class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        return solve (0, 0, triangle, n,new HashMap<String,Integer>());
    }
    
    private int solve (int row, int col, List<List<Integer>> triangle, int n,HashMap<String,Integer> memo){
        
        // Base case
        if (row == n - 1) {
            return triangle.get(n - 1).get(col);
        }
        
        String key = row+"-"+col;
        if(memo.containsKey(key))
            return memo.get(key);
        
        // Moving Down
        int d = triangle.get(row).get(col) + solve(row + 1, col, triangle, n,memo);
        
        // Moving Diagonal
        int dg = triangle.get(row).get(col) + solve(row + 1, col + 1, triangle, n,memo);
        
        int ans = Math.min(d, dg);
        memo.put(key,ans);
        return ans;
    }
}