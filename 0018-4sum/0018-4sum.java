class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();

        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                
                int k = j+1;
                int l = n-1;

                while(l>k){
                    long sum = (long)(nums[i]+nums[j])+(long)(nums[k]+nums[l]);
                    
                    if(sum==target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);    
                        ans.add(temp);  
                        k++;
                        l--;          
                    }else if(sum>target){
                        l--;
                    }else{
                        k++;
                    }
                }
            }
        }

        List<List<Integer>> ans1 = new ArrayList<>();
        for(List<Integer> ls: ans){
            ans1.add(ls);
        }
        return ans1;
    }
}