//{ Driver Code Starts
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
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

class Pair{
    int node,dist;
    Pair(int dist,int node){
        this.node = node;
        this.dist = dist;
    }
}

// https://www.youtube.com/watch?v=V6H1qAeB-l4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=31
class Solution {
    //Function to find the shortest distance of all the vertices from the source vertex S.
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {
        int[] dist = new int[v];
        for(int i=0;i<v;i++){
            dist[i] = (int)(1e9);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.dist-y.dist);
        pq.add(new Pair(0,s));
        dist[s] = 0;
        
        while(!pq.isEmpty()){
            Pair cPair = pq.peek();
            int cNode = cPair.node;
            int cDist = cPair.dist;
            pq.remove();
            
            for(ArrayList<Integer> it:adj.get(cNode)){
                int childNode = it.get(0);
                int childDist = it.get(1);
                
                if((childDist+cDist)<dist[childNode]){
                    dist[childNode] = childDist+cDist;
                    pq.add(new Pair(childDist+cDist,childNode));
                }
            }
        }
        return dist;
    }
}

