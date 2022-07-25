class Solution {
    public int maxArea(int[] height) {
        int answer = Integer.MIN_VALUE;
        
        int leftPointer = 0;
        int rightPointer = height.length - 1;

        // two pointers approach
        while(leftPointer < rightPointer){

            int pillar1 = height[leftPointer];  
            int pillar2 =  height[rightPointer];

            int h = Math.min(pillar1,pillar2);  
            int b = rightPointer - leftPointer;  

            int area = h*b;  

            answer = Math.max(answer,area);  

            if(pillar1 > pillar2){
                rightPointer--;
            }else{
                leftPointer++;
            }  

        }
        return answer;
        
    }
}