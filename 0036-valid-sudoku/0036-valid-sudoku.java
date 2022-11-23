class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j])) {
                    if (!rows[i].add(board[i][j])) return false;
                    if (!columns[j].add(board[i][j])) return false;
                    int boxId = (3*(i/3)) + (j/3);
                    if (!boxes[boxId].add(board[i][j])) return false;
                }
            }
        }
        
        return true;
    
    }
}