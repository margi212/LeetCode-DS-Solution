class Solution {
    public List<Integer> intersection(int[][] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                if(!map.containsKey(nums[i][j])){
                    map.put(nums[i][j],1);
                }else{
                    int counter = map.get(nums[i][j]);
                    map.put(nums[i][j],++counter);
                }
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value == nums.length){
                result.add(key);
            }
        }
        
        Collections.sort(result); 
        return result;        
    }
}