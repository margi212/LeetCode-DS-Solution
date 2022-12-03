class Solution {
    public String frequencySort(String s) {
        StringBuilder res = new StringBuilder();
        HashMap<Character,Integer> freqMap = new HashMap<>();
        
        for(Character ch:s.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
        
        freqMap.entrySet().stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .forEach(x -> {
            for(int i=0;i<x.getValue();i++){
                res.append(x.getKey());
            }
        });
        
        return res.toString();
    }
}