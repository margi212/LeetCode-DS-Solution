class Solution {
    public int maxLength(List<String> arr) {
        return solve(arr, 0, "");
    }
    
    public int solve(List<String> arr, int ind, String s) {
        if(ind == arr.size()){
            return s.length();
        }
        
        String str = s + arr.get(ind);
        HashSet<Character> set= new HashSet<>();
        boolean flag= true;
        
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(set.contains(ch)){
                flag= false;
                break;
            }
            set.add(ch);
        }
        
        int pick = 0;
        
        if(flag)
            pick = solve(arr, ind+1, str);
        int leave = solve(arr, ind+1, s);
        
        return Math.max(pick, leave);
    }
}