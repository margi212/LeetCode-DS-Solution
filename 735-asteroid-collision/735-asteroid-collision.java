class Solution {
    public int[] asteroidCollision(int[] asteroids) {
               
        Stack<Integer> stack = new Stack<>();
       
        for(int i=0;i<asteroids.length;i++){
            int cVal = asteroids[i];
            
            if(cVal>0){
                //positive
                stack.push(cVal);
            }else{
                //negative
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek()< Math.abs(cVal)){
                    stack.pop();
                }
                
                if(stack.isEmpty() || stack.peek()<0){
                    //same direction
                    stack.push(cVal);
                }
                
                if(stack.peek() == Math.abs(cVal)){
                    //both are same then remove and do not push
                    stack.pop();
                }
                
            }
        }
        
        int[] answer = new int[stack.size()];
        int cIndex = stack.size()-1;
        
        while(!stack.isEmpty()){
            //LIFO : stack
            answer[cIndex--] = stack.pop();
        }
                
        return answer;
    }
}