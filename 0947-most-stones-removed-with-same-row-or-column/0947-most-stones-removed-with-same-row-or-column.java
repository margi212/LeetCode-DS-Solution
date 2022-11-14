//https://www.youtube.com/watch?v=OwMNX8SPavM

class Disjoint{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public Disjoint(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findUperParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        
        int ulp = findUperParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    
    public void unionByRank(int u,int v){
        int ulp_u = findUperParent(u);
        int ulp_v = findUperParent(v);
        
        if(ulp_u==ulp_v)
            return;
        
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        } else if(rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
        } else {
            parent.set(ulp_v,ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
        }
        
    }
    
    public void unionBySize(int u,int v){
        int ulp_u = findUperParent(u);
        int ulp_v = findUperParent(v);
        
        if(ulp_u==ulp_v)
            return;
        
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u) + size.get(ulp_v));
        }
        
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        int n = stones.length;
        
        for(int[] i:stones){
            maxRow = Math.max(maxRow,i[0]);
            maxCol = Math.max(maxCol,i[1]);
        }
        
        Disjoint ds = new Disjoint(maxRow+maxCol+1);
        HashMap<Integer,Integer> stoneNodeMap = new HashMap<>();
        
        for(int[] i:stones){
            int nodeRow = i[0];
            int nodeCol = i[1] + maxRow +1;
            ds.unionBySize(nodeRow,nodeCol);
            stoneNodeMap.put(nodeRow,1);
            stoneNodeMap.put(nodeCol,1);
        }
        
        int cnt = 0;
        for(Map.Entry<Integer,Integer> it:stoneNodeMap.entrySet()){
            if(ds.findUperParent(it.getKey()) == it.getKey()){
                cnt++;
            }
        }
        
        return n - cnt;
    }
}