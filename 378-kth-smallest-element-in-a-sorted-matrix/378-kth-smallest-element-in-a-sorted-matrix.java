class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        //int[] res = new int[m*n];
        
        List<Integer> res= new ArrayList();
    
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res.add(matrix[i][j]);
            }
        }
     
        Collections.sort(res);
        return res.get(k-1);
    }
}