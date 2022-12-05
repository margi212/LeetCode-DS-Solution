//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(St[0]);
            int m = Integer.parseInt(St[1]);
            int k = Integer.parseInt(St[2]);
            
            int[][] mat = new int[n][m];
            
            for(int i=0; i<n; i++)
            {
                String S[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                    mat[i][j] = Integer.parseInt(S[j]);
            }

            Solution ob = new Solution();
            System.out.println(ob.shotestPath(mat,n,m,k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Node{
    int x,y,k,dist;
    Node(int x,int y,int k,int dist) {
        this.x = x;
        this.y = y;
        this.k = k;
        this.dist = dist;
    }
}

class Solution {
    static int shotestPath(int[][] mat, int m, int n, int k) {   // code here
        int arrx[] = {0,0,1,-1};
        int arry[] = {1,-1,0,0};
        int out = Integer.MAX_VALUE;
        Queue<Node> q = new LinkedList<>();
        boolean vist[][][] = new boolean[m][n][k+1];
        vist[0][0][0] = true;
        q.add(new Node(0,0,0,0));
        while(!q.isEmpty())
        {
            Node current = q.poll();
            if(current.x == m-1 && current.y == n-1)
            {
                out = Math.min(out,current.dist);
                return out;
            }
            for(int i = 0;i<4;i++)
            {
                int x0 = current.x+arrx[i];
                int y0 = current.y+arry[i];
                if(x0>=0 && x0<m && y0>=0 && y0<n)
                {
                    int k0 = current.k+mat[x0][y0];
                    if(k0<=k && !vist[x0][y0][k0])
                    {
                        vist[x0][y0][k0] = true;
                        q.add(new Node(x0,y0,k0,current.dist+1));
                    }
                }
            }
        }
        return -1;
}
};