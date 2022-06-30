// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int first = getFirst(arr,n,x);
        int last = getLast(arr,n,x);
        
        if(first==-1)
            return 0;
        return last-first+1;
    }
    
    private int getFirst(int[] arr,int n,int target){
        int start = 0;
        int end = n-1;
        
        int anId = -1;
        
        while(start<=end){
            int mid = end-start/2;
            
            if(arr[mid]==target){
                anId = mid;
                end = mid - 1;
            }else if(arr[mid]<target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return anId;
    }
    
    private int getLast(int[] arr,int n,int target){
        int start = 0;
        int end = n-1;
        
        int anId = -1;
        
        while(start<=end){
            int mid = end-start/2;
            
            if(arr[mid]==target){
                anId = mid;
                start = mid + 1;
            }else if(arr[mid]<target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return anId;
    }
}