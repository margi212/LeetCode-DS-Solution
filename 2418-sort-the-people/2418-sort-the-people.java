class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int size = heights.length;
        TreeMap<Integer,String> map = new TreeMap<>(Collections.reverseOrder());
        
        String[] res = new String[size];
        
        for(int i=0;i<size;i++){
            map.put(heights[i],names[i]); 
        }
         
        int j = 0;
        for(Map.Entry<Integer,String> mp:map.entrySet()){
            res[j] = mp.getValue();
            j++;
        }
        return res;
    }
}