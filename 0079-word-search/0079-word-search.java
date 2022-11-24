class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for(int cRow = 0;cRow<m;cRow++){
            for(int cCol = 0; cCol<n; cCol++){
                if(dfs(cRow,cCol,m,n,board,word,0)){
                    return true;   
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(int cRow,int cCol,int m,int n, char[][] board,String word,int cWordSize){
        
        if(cWordSize >= word.length())
            return true;
       
        if(cRow<0 || cRow>=m || cCol<0 || cCol>=n || board[cRow][cCol] != word.charAt(cWordSize)){
            return false;
        }
        
        boolean exist = false;
        if(board[cRow][cCol] == word.charAt(cWordSize)){
            board[cRow][cCol] += 100;
            exist = dfs(cRow + 1, cCol, m, n, board, word, cWordSize + 1) ||
                dfs(cRow, cCol + 1, m, n,board, word, cWordSize + 1) ||
                dfs(cRow - 1, cCol, m, n,board, word, cWordSize + 1) ||
                dfs(cRow, cCol - 1, m, n,board, word, cWordSize + 1);
            board[cRow][cCol] -= 100;
        }
        
        return exist;
    }
}