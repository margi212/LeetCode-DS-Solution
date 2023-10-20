class Solution {
    public void nextPermutation(int[] nums) {
        int index1 = -1;
        int index2 = -1;
        int n = nums.length;

        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index1 = i;
                break;
            }
        }

        if(index1==-1){
            reverse(nums,0,n-1);
            return;
        }

        for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[index1]){
                index2 = i;
                break;
            }
        }
        
        swap(nums,index1,index2);

        reverse(nums,index1+1,n-1);
    }

    private void swap(int[] nums,int index1,int index2){
        int temp =  nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}