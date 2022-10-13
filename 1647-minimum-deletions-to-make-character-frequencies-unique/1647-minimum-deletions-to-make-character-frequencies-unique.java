class Solution {
    public int minDeletions(String s) {
        int res = 0;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        char[] ch = s.toCharArray();
        for(char c:ch){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(Character c:map.keySet()){
            int count = map.get(c);
            if(!set.contains(count)){
                set.add(count);
            }else{
                while(count>0 && set.contains(count)){
                    count--;
                    res++;
                }
                if(count>0){
                    set.add(count);
                }
            }    
        }
        
        return res;
    }
}