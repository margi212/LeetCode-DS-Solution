class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        //aditya verma youtube
        //https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=5
        //https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/1993978/JAVAor-Sliding-Window-or-Hash-Table
        int i = 0;
        int j = 0;
        int count = 0;
        int k = p.length();
        
        List<Integer> answ = new ArrayList<Integer>();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(Character ch : p.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
               
        while(j < s.length()){
            
            //calculation part
            Character cChar = s.charAt(j);
            if(map.containsKey(cChar)) {
                map.put(cChar,map.get(cChar)-1);
                if(map.get(cChar) == 0){
                    count++;
                }
            }
            
            if(j-i+1 < k){
                j++;        
            }else if(j-i+1 == k){
                if(count == map.size()){
                    answ.add(i);
                }
               
                if(map.containsKey(s.charAt(i))) {
                    if(map.get(s.charAt(i)) == 0){
                        count--;
                    }
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                   
                }
                
                i++;
                j++;
            }
        }
        return answ;
    }
    
    
}