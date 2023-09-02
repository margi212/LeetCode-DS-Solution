class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char cCh = s.charAt(i);
            map.put(cCh,map.getOrDefault(cCh,0)+1);   
        }
        
        //sort map according to value
        map = sortByValue(map);
        
        // System.out.println(Arrays.asList(map));
        
        String ans = "";
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            int val = entry.getValue();
            for(int i=0;i<val;i++)
                ans= ans+entry.getKey();
        }
        
        return ans;
    }
    
     public static HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> hm) {
        HashMap<Character, Integer> temp = hm.entrySet().stream()
                                            .sorted((i1, i2)
                                                      -> i2.getValue().compareTo(i1.getValue()))
                                            .collect(Collectors.toMap(
                                                Map.Entry::getKey,
                                                Map.Entry::getValue,
                                                (e1, e2) -> e1, LinkedHashMap::new));
 
        return temp;
    }
}