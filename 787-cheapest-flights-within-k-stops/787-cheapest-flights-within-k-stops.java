class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        int[] costs = new int[n];
        
        Arrays.fill(costs,Integer.MAX_VALUE);
        
        costs[src] = 0;
        
        for(int i = 0; i <= k; i++){
            int[] tempPrices = Arrays.copyOf(costs, n);
            
            for(int[] edge:flights){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                
                if(costs[u] == Integer.MAX_VALUE)
                    continue;
                
                 if (costs[u] + w < tempPrices[v]){
                     tempPrices[v] = costs[u] + w;
                 }
            }
            
            costs = tempPrices;
        }
        
        return costs[dest]==Integer.MAX_VALUE ? -1 : costs[dest];  
    }
}