class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        
        int m = matches.length;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int w =0;w<m;w++){
           // map.put(Long.valueOf(matches[w][0]), 0);
             map.put(matches[w][0], 0);
        }
        
        for(int w =0;w<m;w++){
            map.put(matches[w][1], map.getOrDefault(matches[w][1],0)+1);        
        }
        
        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        for(Map.Entry<Integer,Integer> mp:map.entrySet()){
            //System.out.println(mp.getKey()+":"+mp.getValue());
            if(mp.getValue()==0){
                //zeroLoss.add((int) (long)mp.getKey());
                zeroLoss.add(mp.getKey());
            }else if(mp.getValue()==1){
               // oneLoss.add((int) (long)mp.getKey());
                 oneLoss.add(mp.getKey());
            }
            
        }
        
        Collections.sort(zeroLoss);
        Collections.sort(oneLoss);
        
        ans.add(zeroLoss);
        ans.add(oneLoss);
        
        return ans;
    }
}