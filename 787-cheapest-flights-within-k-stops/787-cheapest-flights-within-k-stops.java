//https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/1926143/Bellman-Ford-oror-Easy-Understanding-oror-Java
//https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        int[] costs = new int[n];
        
        Arrays.fill(costs,Integer.MAX_VALUE);
        
        costs[src] = 0;
        
        for(int i = 0; i <= k; i++){
            int[] tempCosts = Arrays.copyOf(costs, n);
            
            for(int[] edge:flights){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                
                if(costs[u] != Integer.MAX_VALUE  && costs[u] + w < tempCosts[v]){
                     tempCosts[v] = costs[u] + w;
                }
            }
            
            costs = tempCosts;
        }
        
        return costs[dest]==Integer.MAX_VALUE ? -1 : costs[dest];  
    }
}