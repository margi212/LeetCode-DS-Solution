class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        
        for(int i=0;i<n;i++){
            HashMap<Integer,Boolean> map1 = new HashMap<>();
            HashMap<Integer,Boolean> map2 = new HashMap<>();
           
            for(int j=0;j<n;j++){
                
                 if(!map1.containsKey(matrix[i][j])){
                     map1.put(matrix[i][j],true);
                 }else{
                     map1.put(matrix[i][j],false);
                     //return false;
                 }
                
                 if(!map2.containsKey(matrix[j][i])){
                     map2.put(matrix[j][i],true);
                 }else{
                     map2.put(matrix[j][i],false);
                     //return false;
                 }
            }
            
            
        
        
   
        for (Map.Entry<Integer,Boolean> entry : map1.entrySet()) {
                Integer key = entry.getKey();
                Boolean value = entry.getValue();
                if(!value)
                    return false;
                
            }
        
        for (Map.Entry<Integer,Boolean> entry : map2.entrySet()) {
                Integer key = entry.getKey();
                Boolean value = entry.getValue();
                if(!value)
                    return false;
                
            }
        }
        return true;
        
//             int n = matrix.length ;
//             Set<String> seen = new HashSet<>();
//             for(int i =0 ;i < n ; i++){
//                 for(int j = 0 ;j < n ; j++){
//                     if(!seen.add(matrix[i][j]+"row"+i))
//                         return false;
                    
//                     if(!seen.add(matrix[i][j]+"col"+j))
//                         return false;
                  
//                 }
//             }
            
//             return true;
    }
}