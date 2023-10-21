class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> dequeue = new ArrayDeque<>();
        int maxSum = nums[0];

        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i] + (dequeue.isEmpty()?0:dequeue.getFirst());
            maxSum = Math.max(maxSum,nums[i]);

            while(!dequeue.isEmpty() && nums[i]>dequeue.getLast()){
                dequeue.removeLast();
            }

            if(nums[i]>0){
                dequeue.addLast(nums[i]);
            }

            if(i>=k && !dequeue.isEmpty() && dequeue.getFirst() == nums[i-k]){
                dequeue.removeFirst();
            }
        }
        return maxSum;
    }
}