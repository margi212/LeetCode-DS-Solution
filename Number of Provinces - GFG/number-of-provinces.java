//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends

//https://www.youtube.com/watch?v=ZGr5nX-Gi6Y&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=47
//User function Template for Java
class DisjointSet{
    int[] rank;
    int[] parent;
    DisjointSet(int v){
        rank = new int[v];
        parent = new int[v];
        Arrays.fill(rank,0);
        for(int i=0;i<v;i++){
            parent[i] = i;
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
}
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        DisjointSet ds = new DisjointSet(V);
        
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j)==1)
                    ds.unionByRank(i,j);
            }    
        }
        
        Set<Integer> ans = new HashSet<>();
        for(int i=0;i<V;i++){
           ans.add(ds.findUpar(i));
        }
            
        return ans.size();
        
    }
};