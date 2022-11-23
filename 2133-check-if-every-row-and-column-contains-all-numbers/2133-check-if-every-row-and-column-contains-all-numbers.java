class Solution {
    public boolean checkValid(int[][] matrix) {
//         int n = matrix[0].length;
        
//         for(int i=0;i<n;i++){
//             HashMap<Integer,Integer> map1 = new HashMap<>();
//             HashMap<Integer,Integer> map2 = new HashMap<>();
         
//             for(int j=0;j<n;j++){
//                  if(!map1.containsKey(matrix[i][j])){
//                      map1.put(matrix[i][j],1);
//                  }else{
//                      return false;
//                  }
                
//                  if(!map2.containsKey(matrix[j][i])){
//                      map2.put(matrix[j][i],1);
//                  }else{
//                      return false;
//                  }
//             }
//         }
        
//         return true;
        
            int n = matrix.length ;
            Set<String> seen = new HashSet<>();
            for(int i =0 ;i < n ; i++){
                for(int j = 0 ;j < n ; j++){
                    if(!seen.add(matrix[i][j]+"row"+i))
                        return false;
                    
                    if(!seen.add(matrix[i][j]+"col"+j))
                        return false;
                  
                }
            }
            
            return true;
    }
}