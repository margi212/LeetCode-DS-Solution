// { Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    public void shortest_distance(int[][] matrix){
        int n = matrix.length;
        
        int costs[][] = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == -1){
                    costs[i][j] = Integer.MAX_VALUE; 
                }else{
                    costs[i][j] = matrix[i][j]; 
                }
            }
        }
        
        for(int intermediate = 0; intermediate < n; intermediate++){
            for(int src = 0; src < n; src++){
                for(int dest = 0; dest < n; dest++){
                    if(costs[src][intermediate] != Integer.MAX_VALUE && costs[intermediate][dest] != Integer.MAX_VALUE){
                        costs[src][dest] = Math.min(costs[src][dest],
                                            costs[src][intermediate]+costs[intermediate][dest]);
                    }
                }
            }
        }
    
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(costs[i][j] == Integer.MAX_VALUE){
                    matrix[i][j] = -1; 
                }else{
                    matrix[i][j] = costs[i][j]; 
                }
            }
        }
    }
}