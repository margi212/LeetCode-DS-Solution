//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int node;
    int dist;
    Pair(int node,int dist){
        this.node = node;
        this.dist= dist;
    }
}
class Solution {
    
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        List<List<Pair>> graph = createGraph(edges,n,m);
        
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        int[] parent = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i] = i;
        }
        
        int src=1;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)->a.dist-b.dist);
        pq.add(new Pair(src,0));
        dist[src] = 0;
        
        while(!pq.isEmpty()){
            Pair cPair = pq.peek();
            pq.remove();
            int cNode = cPair.node;
            int cDist = cPair.dist;
            
            for(Pair it: graph.get(cNode)){
                int childNode = it.node;
                int childDist = it.dist;
                
                if(childDist+cDist<dist[childNode]){
                    dist[childNode] = childDist+cDist;
                    parent[childNode] = cNode;
                    pq.add(new Pair(childNode,dist[childNode]));
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        if(dist[n] == Integer.MAX_VALUE){
            ans.add(-1);
            return ans;
        }
        
        int destination = n;
        
        while(parent[destination]!=destination){
           ans.add(destination);
           destination = parent[destination];
        }
        
        ans.add(src);
        Collections.reverse(ans);
        return ans;
    }
    
    private static List<List<Pair>> createGraph(int[][] edges,int n,int m){
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        } 
        
        for(int i=0;i<m;i++){
            // adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            // adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            adj.get(u).add(new Pair(v,wt));
           
            adj.get(v).add(new Pair(u,wt));
        }
        return adj;
    }
}