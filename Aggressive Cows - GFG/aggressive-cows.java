//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int cows, int[] stalls) {
        Arrays.sort(stalls);
        int low = 1, high = stalls[n - 1] - stalls[0];

        while (low <= high) {
            int mid = (low + high) >> 1;

            if (isPossible(stalls, n, cows, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    
    static boolean isPossible(int a[], int n, int cows, int minDist) {
        int cntCows = 1;
        int lastPlacedCow = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] - lastPlacedCow >= minDist) {
                cntCows++;
                lastPlacedCow = a[i];
            }
        }
        if (cntCows >= cows) return true;
        return false;
    }
    
    // public static boolean isPossible(int n, int mid, int[] stalls){
    //     int cow =1,lastPlacedCow = stalls[0];
    //     for (int i = 1; i < n; i++) {
    //         if (stalls[i] - lastPlacedCow >= mid) {
    //             cow++;
    //             lastPlacedCow = stalls[i];
    //             if(cow==mid)
    //                 return true;
    //         }
    //     }
        
    //     return false;
    // }
}