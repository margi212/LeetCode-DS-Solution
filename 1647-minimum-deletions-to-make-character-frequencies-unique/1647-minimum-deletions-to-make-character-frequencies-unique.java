class Solution {
    public int minDeletions(String s) {
        char[] ch = s.toCharArray();
        HashMap<Character,Integer> countMap = new HashMap<>();
        
        for(char c:ch){
            countMap.put(c,countMap.getOrDefault(c,0)+1);
        }
        
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        
        for(Character c: countMap.keySet()){
            int count = countMap.get(c);
            if(!set.contains(count)){
                set.add(count);
            }else{
                while(count>0 && set.contains(count)){
                    ans++;
                    count--;
                }
                if(count>0){
                    set.add(count);
                }
            }
        }
        
        return ans;
        
    }
}