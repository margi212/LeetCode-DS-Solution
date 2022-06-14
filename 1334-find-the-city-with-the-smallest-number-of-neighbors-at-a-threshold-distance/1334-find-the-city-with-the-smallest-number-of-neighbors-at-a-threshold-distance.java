class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
         int costs[][] = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    costs[i][j] = 0; 
                }else{
                    costs[i][j] = Integer.MAX_VALUE; 
                }
            }
        }
        
        for(int[] edge:edges){
            int src = edge[0];
            int dest = edge[1];
            int cost = edge[2];
            costs[src][dest] = cost;
            costs[dest][src] = cost;
        }
        
        for(int intermediate = 0; intermediate < n; intermediate++){
            for(int src = 0; src < n; src++){
                for(int dest = 0; dest < n; dest++){
                    if(costs[src][intermediate] != Integer.MAX_VALUE && costs[intermediate][dest] !=                                                                                                    Integer.MAX_VALUE){
                        costs[src][dest] = Math.min(costs[src][dest],
                                            costs[src][intermediate]+costs[intermediate][dest]);
                    }
                }
            }
        }
       
        int maxReach = 101;
        int answer = -1;
        
        for(int cCity = 0 ;cCity<n;cCity++){
            int reach = 0;
            for(int cCityNeigh=0;cCityNeigh<n;cCityNeigh++){
                if(costs[cCity][cCityNeigh] <= distanceThreshold){
                    reach += 1;
                }
            }
            
            if(reach<=maxReach){
                maxReach = reach;
                answer = cCity;
            }
        }
        
        return answer;
    }
}