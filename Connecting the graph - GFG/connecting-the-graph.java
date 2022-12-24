//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

//https://www.youtube.com/watch?v=FYrl7iz9_ZU&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=48
class DisjointSet{
    int[] rank;
    int[] parent;
    int[] size;
    DisjointSet(int v){
        rank = new int[v];
        parent = new int[v];
        size = new int[v];
        Arrays.fill(rank,0);
        for(int i=0;i<v;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int findUpar(int node){
        if(parent[node]==node){
            return node;
        }
        parent[node] = findUpar(parent[node]);
        return parent[node];
    }
    
    public void unionByRank(int u,int v){
        int upar_u = findUpar(u);
        int upar_v = findUpar(v);
        
        if(upar_u==upar_v){
            return;
        }
        
        if(rank[upar_u]<rank[upar_v]){
            parent[upar_u] = parent[upar_v];
        }else if(rank[upar_u]>rank[upar_v]){
            parent[upar_v] = parent[upar_u];
        }else{
            parent[upar_v] = upar_u;
            rank[upar_u]+=1;
        }
    }
    
    public void unionBySize(int u,int v){
        int upar_u = findUpar(u);
        int upar_v = findUpar(v);
        
        if(upar_u==upar_v){
            return;
        }
        
        if(size[upar_u]<size[upar_v]){
            parent[upar_u] = upar_v;
            size[upar_v]+=size[upar_u];
        }else{
            parent[upar_v] = upar_u;
            size[upar_u]+=size[upar_v];
        }
    }
}
class Solution {

    public int Solve(int n, int[][] edges) {
           // code here
        DisjointSet ds = new DisjointSet(n);
        
        int extraEdge = 0;
        int m = edges.length;
        for(int i=0;i<m;i++){
            int[] edge = edges[i];
            int src = edge[0];
            int dest = edge[1];
            if(ds.findUpar(src)==ds.findUpar(dest)){
                extraEdge++;
            }else
                ds.unionBySize(src,dest);
        }
     
        int cnt = 0;
        for(int i=0;i<n;i++){
           if(ds.parent[i] == i){
               cnt++;
           }
        }
            
        int ans = cnt-1;
        if(extraEdge<ans){
            return -1;
        }
        return ans;
        
    }
}