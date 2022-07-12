class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Boolean> ans = new HashMap<Integer,Boolean>();
        ArrayList<Integer> result = new ArrayList<>();
  
        for(int cNum:nums1){
            if(!ans.containsKey(cNum)){
                ans.put(cNum,true);
            }
        }
        
        for(int cNum:nums2){
            if(ans.containsKey(cNum) && ans.get(cNum)){
                result.add(cNum);
                ans.put(cNum,false);
            }
        }
        
        int[] res = new int[result.size()];
        for(int i=0;i<result.size();i++){
            res[i] = result.get(i);
        }
        return res;
        
    }
}