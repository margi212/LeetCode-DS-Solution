class Solution {
    public int diagonalSum(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
                
        int sum = 0;
        for(int row=0;row<m;row++) {
            for(int col=0;col<n;col++) {
                if(row == col){
                    sum = sum + mat[row][col];
                }
                
                if ((row + col) == (n - 1) && row!=col) {
                    sum = sum + mat[row][col];
                }
            }
        }
        
        return sum;
    }
}