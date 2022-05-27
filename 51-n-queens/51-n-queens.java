class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        
        nQueens(board,0,n,answer);
        return answer;
    }
    
    private void nQueens(char[][] board,int currentRow,int n, List<List<String>> answer){
        if(currentRow==n){
            answer.add(createAns(board,n));
            return;
        }
    
        for(int currentCol = 0;currentCol<n;currentCol++){
            if(isValid(board,currentRow,currentCol,n)){
                board[currentRow][currentCol]='Q';
                nQueens(board,currentRow+1,n,answer);
                board[currentRow][currentCol]='.';
            }   
        }
        
        return;
    }

    private List<String> createAns(char[][] board,int n){
        List<String> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            String cRow = "";
            for(int j=0;j<n;j++){
                cRow += board[i][j];
            }
            ans.add(cRow);
        }
        
        return ans;
    }

   private boolean isValid(char[][] board,int currentRow,int currentCol,int n){
    return isRowValid(board,currentRow,n) && isColValid(board,currentCol,n) && isGridValid(board,currentRow,currentCol,n);
   }

    private boolean isRowValid(char[][] board, int currentRow, int n) {
        for(int currentCol = 0; currentCol<n; currentCol++)
            if(board[currentRow][currentCol] == 'Q')
                return false;
        return true;
    }
    
    private boolean isColValid(char[][] board, int currentCol, int n) {
        for(int currentRow = 0; currentRow<n; currentRow++)
            if(board[currentRow][currentCol] == 'Q')
                return false;
        return true;
    }
    
    private boolean isGridValid(char[][] board,int currentRow, int currentCol, int n) {
         
        //leftUpDia
        int x = currentRow;
        int y = currentCol;
        
        while(x >= 0 && y >= 0){
            if(board[x][y]=='Q')
                return false;
            x-=1;
            y-=1;
        }
            
        //rigthUp
         x = currentRow;
         y = currentCol;
        
        while(x >= 0 && y < n){
            if(board[x][y]=='Q')
                return false;
            x-=1;
            y+=1;
        }
        
        return true;
    }
}