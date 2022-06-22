// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Pair implements Comparable<Pair>{
    int cost;
    int vertex;
    Pair(int vertex,int cost){
        this.cost = cost;
        this.vertex = vertex;
    }
    
    public int compareTo(Pair p){
        return this.cost - p.cost;
    }
}
class Solution {
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V];
        int minCost = 0;
        
        pq.add(new Pair(0,0));
        
        while(!pq.isEmpty()){
            Pair cp = pq.remove();
            int cVertex = cp.vertex;
            int cCost = cp.cost;
            
            if(visited[cVertex])
                continue;
                
            visited[cVertex] = true;
            minCost += cCost;
            
            for(ArrayList<Integer> cNeigh : adj.get(cVertex)){
                int cNeighVertex = cNeigh.get(0);
                int cNeighCost = cNeigh.get(1);
               
                if(visited[cNeighVertex])
                    continue;
               // cNeighCost + cCost is for Dijstra's
               // pq.add(new Pair(cNeighVertex,cNeighCost + cCost)); 
                pq.add(new Pair(cNeighVertex,cNeighCost));
            }
        }
        
        return minCost;
    }
}
