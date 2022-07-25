class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = 0;
        int n = matrix[0].length-1;
           
        while(m<matrix.length && n>=0){
            int cItem = matrix[m][n];
            
            if(cItem == target)
                return true;
            else if(cItem>target){
                n--;
            }else{
                m++;
            }                
        }
        
        return false;
//         for(int i=0;i<matrix.length;i++){
//             for(int j=0;j<matrix[i].length;j++){
//                 if(target==matrix[i][j])
//                     return true;
//             }    
//         }
        
//         return false;
    }
}