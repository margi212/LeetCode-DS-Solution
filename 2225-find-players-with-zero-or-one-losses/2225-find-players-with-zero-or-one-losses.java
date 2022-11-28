class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        
        int m = matches.length;
        
        //used tree map because order is matter
        //Key:PlayerNumber Value:How many time loses
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(int w =0;w<m;w++){
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
                zeroLoss.add(mp.getKey());
            }else if(mp.getValue()==1){
                 oneLoss.add(mp.getKey());
            }
        }
        
        ans.add(zeroLoss);
        ans.add(oneLoss);
        
        return ans;
    }
}