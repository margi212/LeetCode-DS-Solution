class Solution {
    public int[] frequencySort(int[] nums) {
        List<Integer> keys = new ArrayList<>();
		
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(Integer num:nums){
            keys.add(num);
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        Collections.sort(keys,(a,b)->{
			if(map.get(a)==map.get(b)){
				return b-a;
			}
			return map.get(a)-map.get(b);
		});
        
        int res[] = new int[keys.size()];
		for(int i=0;i<keys.size();i++){
			res[i]=keys.get(i);
		}
        
		return res;
    }
}