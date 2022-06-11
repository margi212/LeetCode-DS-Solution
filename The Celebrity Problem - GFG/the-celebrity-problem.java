// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int trust[][], int n)
    {
    	int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int x = trust[i][j];
                outDegree[i] += x;
                inDegree[j] += x;
            }
        }
        
        for(int cPeople = 0;cPeople<n;cPeople++){
            if(inDegree[cPeople] == n-1 && outDegree[cPeople] == 0){
                return cPeople;
            }
        }
        
        return -1;
    }
}