class Solution {
    public int findCircleNum(int[][] graph) {
        int n = graph[0].length;
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int cCity = 0;cCity < n; cCity++){
            if(visited[cCity] == false){
                dfs(graph,cCity,n,visited);
                answer += 1;
            }
        }
        return answer;
    }
    
    private void dfs(int[][] graph,int cCity,int n,boolean[] visited){
        if(visited[cCity])
            return;
        
        visited[cCity] = true;
        //entire row as neightbour
        int[] neighbours = graph[cCity];
        for(int i = 0;i<n;i++){
            if(neighbours[i]==1)
                dfs(graph,i,n,visited);
        }
    }
}