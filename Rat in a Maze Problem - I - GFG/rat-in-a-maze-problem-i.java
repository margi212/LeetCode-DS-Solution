// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
       
        findMazePath(m,n,0,0,"",ans);
        return ans;
    }
    
    private static void findMazePath(int[][] m, int n, int currentRow, int currentCol, String currentPath, ArrayList<String> ans)
    {
        if( currentRow < 0 || currentRow >= n || currentCol < 0 || currentCol >= n || m[currentRow][currentCol] <=0)
            return;
        
        if(currentRow == n-1 && currentCol == n-1){
             ans.add(currentPath);
             return;
        }
        
        m[currentRow][currentCol] = -1;
         
           //down call
        findMazePath(m,n,currentRow +1, currentCol,currentPath + "D", ans);
        
        //left call
        findMazePath(m,n,currentRow , currentCol -1,currentPath + "L", ans);
        
        //right call
        findMazePath(m,n,currentRow , currentCol+1,currentPath + "R", ans);
        
        //up call
        findMazePath(m,n,currentRow-1 , currentCol,currentPath + "U", ans);
          
          m[currentRow][currentCol] = 1;
        
    }
}