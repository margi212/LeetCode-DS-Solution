class Solution {
    public void solveSudoku(char[][] board) {
        sudokuSolver(board,0,0,board.length);
    }
    
    private boolean sudokuSolver(char[][] board,int currentRow,int currentCol,int size){
        if(currentRow==size)
            return true;
        
        int nextRow = 0;
        int nextCol = 0;
        if(currentCol == size-1){
            nextRow = currentRow+1;
            nextCol = 0;
        }else{
            nextRow = currentRow;
            nextCol = currentCol+1;
        }
        
        if(board[currentRow][currentCol]!='.'){
            return sudokuSolver(board,nextRow,nextCol,size);
        }
        
        for(char currentVal = '1'; currentVal <= '9' ; currentVal++){
            if(isSudokuValid(board,currentRow,currentCol,currentVal,size)){
                board[currentRow][currentCol] = currentVal;
                if(sudokuSolver(board,currentRow,currentCol,size)){
                    return true;
                }else{
                    board[currentRow][currentCol] = '.';
                }
            }
        }
        return false;        
    }
    
    private boolean isSudokuValid(char[][] board, int currentRow, int currentCol, char currVal, int n){
        return isRowValid(board, currentRow, currVal, n) && isColValid(board, currentCol, currVal, n)
            && isSubGridValid(board, currentRow, currentCol, currVal, n);
    }
    
    private boolean isSubGridValid(char[][] board,int currentRow, int currentCol, char currVal, int n) {
        int startRowIndex = 3 * (currentRow/3);
        int startColIndex = 3 * (currentCol/3);
         
        for(int i= startRowIndex; i<= startRowIndex+2 ; i++)
            for( int j= startColIndex; j<=startColIndex+2; j++)
                if(board[i][j] == currVal)
                return false;
        return true;
    }
    
    private boolean isRowValid(char[][] board, int currentRow, char currVal, int n) {
        for( int currentCol = 0; currentCol<=8; currentCol++)
            if(board[currentRow][currentCol] == currVal)
                return false;
        return true;
    }
    
    private boolean isColValid(char[][] board, int currentCol, char currVal, int n) {
        for( int currentRow = 0; currentRow<=8; currentRow++)
            if(board[currentRow][currentCol] == currVal)
                return false;
        return true;
    }
    
}