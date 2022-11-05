class TrieNode{
    TrieNode[] children;
    String word;
    
    TrieNode(){
        children = new TrieNode[26];
        word = null;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> answer = new ArrayList<>();
        
        TrieNode root = new TrieNode();
        
        for(String word : words){
            inserWordInTrie(word,root);    
        }
        
        int m = board.length;
        int n = board[0].length;
        
        for(int cRow = 0; cRow < m; cRow++){
            for(int cCol = 0; cCol < n; cCol++){
                dfs(board,cRow,cCol,m,n,root,answer);        
            }
        }
        
        return answer;
    }
    
    private void inserWordInTrie(String word, TrieNode root){
        for(Character ch: word.toCharArray()){
            if(root.children[ch-'a'] == null){
                root.children[ch-'a'] = new TrieNode();
            } 
            
            root = root.children[ch-'a'];
        }
        
        root.word = word;
    }
    
    private void dfs(char[][] board, int cRow, int cCol, int m, int n, TrieNode root, List<String> answer){
        
        if(root.word != null){
            answer.add(root.word);
            // for not repeat
            root.word = null;
        }
        
        if(cRow<0 || cRow>=m || cCol<0 || cCol>=n || board[cRow][cCol]=='.'){
            return;
        }
        
        Character cChar = board[cRow][cCol];
        
        if(root.children[cChar-'a']==null)
            return;
        
        board[cRow][cCol] = '.';
        
        dfs(board,cRow+1,cCol,m,n,root.children[cChar-'a'],answer);
        dfs(board,cRow-1,cCol,m,n,root.children[cChar-'a'],answer);
        dfs(board,cRow,cCol+1,m,n,root.children[cChar-'a'],answer);
        dfs(board,cRow,cCol-1,m,n,root.children[cChar-'a'],answer);
        
        board[cRow][cCol] = cChar;
        
        return;
    }
}