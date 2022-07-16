class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
//         Arrays.sort(nums);
        
//         List<List<Integer>> ans = new ArrayList<>();
        
//         for(int i=0;i<nums.length-2;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 for(int k=j+1;j<nums.length;j++){
//                     if(nums[i]+nums[j]+nums[k] == 0){
//                         List<Integer> trip = new ArrayList<>();
//                         trip.add(nums[i]);
//                         trip.add(nums[j]);
//                         trip.add(nums[k]);
//                         ans.add(trip);
//                     }
//                 }
//             }
//         }
        
//         return ans;
        
        Set<List<Integer>> triplets = new HashSet<>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) triplets.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                if (sum > 0) k--;
                if (sum < 0) j++;
            }
        }
        
        return new ArrayList<List<Integer>>(triplets);
    }
}