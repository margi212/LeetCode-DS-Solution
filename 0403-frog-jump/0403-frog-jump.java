class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],new HashSet<>());
        }
        
        map.get(stones[0]).add(1);
        
        for(int i=0;i<stones.length;i++){
            int cStone = stones[i];
            HashSet<Integer> jumps = map.get(cStone);
            
            for(Integer jump : jumps){
                int position = jump + cStone;
                
                if(position == stones[stones.length-1]){
                    return true;
                }
                if(map.containsKey(position)){
                    if(jump-1 > 0)
                        map.get(position).add(jump-1);
                    map.get(position).add(jump);
                    map.get(position).add(jump+1);
                }
            }
            
        }
        
        return false;   
    }
}