class Pair{
    int vertex;
    int color;
    
    Pair(int vertex,int color){
        this.vertex = vertex;
        this.color = color;
    }
}

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        
        for(int currentVertex = 0; currentVertex < n; currentVertex++){
            
            if(colors[currentVertex] != -1)
                continue;
            
            if(!hasEvenCycle(graph, currentVertex, 0, colors))
                return false;
            
            // if(!hasEvenCycleUsingBFS(graph, currentVertex, 0, colors))
            //     return false;
        }
        
        return true;
    }
    
    private boolean hasEvenCycle(int[][] graph,int cVertex,int cColor,int[] colors){
        if(colors[cVertex] != -1){
           return colors[cVertex] == cColor;
        }
        
        colors[cVertex] = cColor;
        
        for(int cNeigh : graph[cVertex]){
            if(!hasEvenCycle(graph,cNeigh,1-cColor,colors)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean hasEvenCycleUsingBFS(int[][] graph,int vertex,int cColor,int[] colors){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(vertex,0));
        
        while(!q.isEmpty()){
            Pair p = q.remove();
            int cVertex = p.vertex;
            int color =  p.color;
        
            if(colors[cVertex] != -1){
               if(colors[cVertex] != color){
                   return false;
               }
            }else{
                colors[cVertex] = color;
                  
                for(int cNeigh : graph[cVertex]){
                   q.add(new Pair(cNeigh,1-color));
                }
            }
        }      
        
        return true;
    }
}