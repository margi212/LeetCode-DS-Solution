class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
         
        HashMap<Character,Integer> mg = new HashMap<>();
        for(Character ch : magazine.toCharArray()){
            mg.put(ch,mg.getOrDefault(ch,0)+1);
        }
        
        for(Character ch:ransomNote.toCharArray()){
            if(mg.containsKey(ch)){
                if(mg.get(ch)<=0)
                    return false;
                else
                    mg.put(ch,mg.get(ch)-1);
            }else{
                return false;
            }
        }
        
        return true;
    }
}