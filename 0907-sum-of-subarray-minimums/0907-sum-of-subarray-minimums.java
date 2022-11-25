//https://www.youtube.com/watch?v=Ulb3ixSpE4Y
class Pair{
    int elm;
    int minNum;
    Pair(int elm,int minNum){
        this.elm = elm;
        this.minNum = minNum;
    }
}

class Solution {
    public long m = ((long)Math.pow(10,9)) + 7;
        
    public int sumSubarrayMins(int[] arr) {
        
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        ArrayDeque<Pair> stack1 = new ArrayDeque<>();
        ArrayDeque<Pair> stack2 = new ArrayDeque<>();
        
        //left array
        for(int i=0;i<n;i++){
            int cElm = arr[i];
            int count = 1;
            while(!stack1.isEmpty() && stack1.peek().elm>cElm){
                count += stack1.peek().minNum;
                stack1.pop();
            }
            stack1.push(new Pair(cElm,count));
            left[i] = count;
        }
        
        for(int i=n-1;i>=0;i--){
            int cElm = arr[i];
            int count = 1;
            while(stack2.size()!=0 && stack2.peek().elm>=cElm){
                count += stack2.peek().minNum;
                stack2.pop();
            }
            stack2.push(new Pair(cElm,count));
            right[i] = count;
        }
          
        long ans = 0;
        for(int i=0;i<n;i++){
            ans = (ans + left[i] * right[i] * (long) arr[i]) % m;
        }
        return (int)ans;
    }
}