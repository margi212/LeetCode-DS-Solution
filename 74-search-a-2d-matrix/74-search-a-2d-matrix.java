class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(matrix[i][j] == target){
                    res = true;
                    break;
                }
            }
        }        
        return res;
    }
}