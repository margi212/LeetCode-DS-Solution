class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> ans = new HashMap<Integer,Integer>();
        ArrayList<Integer> result = new ArrayList<>();
  
        for(int i = 0; i <nums1.length; i++){
           ans.put(i,nums1[i]);
        }
        
        for(int j = 0; j < nums2.length; j++){
            if(ans.containsValue(nums2[j])){
                result.add(nums2[j]);
            }
            ans.values().remove(nums2[j]);
        }
        
        int[] res = new int[result.size()];
        for(int i=0;i<result.size();i++){
            res[i] = result.get(i);
        }
        return res;
        
    }
}