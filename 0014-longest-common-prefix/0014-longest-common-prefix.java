class Solution {
    public String longestCommonPrefix(String[] arr) {
        StringBuilder res = new StringBuilder();    
        
        Arrays.sort(arr);
        
        char[] first = arr[0].toCharArray();
        char[] last = arr[arr.length-1].toCharArray();
        
        for(int i=0;i<first.length;i++){
            if(first[i]!=last[i])
                break;
                
            res.append(first[i]);
        }
        
        return res.length()>0?res.toString():"";
    }
}