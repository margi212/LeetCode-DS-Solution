//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job jobs[], int n)
    {
        // Sort the jobs based on Profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        
        int max = 0;
        for(int i = 0 ; i < n ; i++) {
           if(jobs[i].deadline > max) {
               max = jobs[i].deadline;
           }
        }
        
        int[] res = new int[max+1];
        for(int i = 1 ; i <= max ; i++) {
            // Initialize the result array
            res[i] = -1;
        }
        
        int countJob = 0, jobProfit = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = jobs[i].deadline ; j > 0 ; j--) {
                if(res[j]==-1){
                    res[j] = i;
                    countJob++;
                    jobProfit += jobs[i].profit;
                    break;
                }
            }
        }
        
        int ans[] = new int[2];
        ans[0] = countJob;
        ans[1] = jobProfit;
        
        return ans;
    }
}


// class Job {
//     int id, profit, deadline;
//     Job(int x, int y, int z){
//         this.id = x;
//         this.deadline = y;
//         this.profit = z; 
//     }
// }
