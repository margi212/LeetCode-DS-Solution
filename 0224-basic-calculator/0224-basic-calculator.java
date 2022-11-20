class Solution {
    public int calculate(String s) {
        int curr = 0;
        int res = 0;
        int sign = 1;
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i<s.length();i++){            
            
            if(Character.isDigit(s.charAt(i))){
                curr = curr*10 +  (s.charAt(i) - '0');
            }
            
            else if (s.charAt(i) == '+' || s.charAt(i) == '-' ){
                res+= sign*curr;
                if(s.charAt(i) == '+') sign = 1;               
                else sign = -1;               
                curr = 0;
            }
            
            else if (s.charAt(i)=='(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;                
            }
            else if (s.charAt(i)==')'){        
                res+= sign*curr;
                res *= stack.pop();
                res += stack.pop();
                curr = 0;                
            }        
        
        }
        return  res+sign*curr;
        
    }
}