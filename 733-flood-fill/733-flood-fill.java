class Solution {
    public int[][] floodFill(int[][] img, int sr, int sc, int newColor) {
        if(img[sr][sc]==newColor) 
            return img;
        
        dfs(img,sr,sc,newColor,img[sr][sc]);
        
        return img;
    }
    
    private void dfs(int[][] img, int sr, int sc, int newColor,int oc) {
        if(sr>=img.length||sr<0 || sc>=img[0].length||sc<0 || img[sr][sc]!=oc)
            return;
        
        img[sr][sc] = newColor;
            
        dfs(img,sr-1,sc,newColor,oc);
        dfs(img,sr+1,sc,newColor,oc);
        dfs(img,sr,sc-1,newColor,oc);
        dfs(img,sr,sc+1,newColor,oc);
        
    }
    
}