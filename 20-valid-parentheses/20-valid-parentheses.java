class Solution {
    public boolean isValid(String s) {
         // add your code here
        Stack<Character> stack = new Stack<>();
        
        for(Character cChar:s.toCharArray()){
            if(cChar=='(' || cChar=='{' || cChar=='['){
                stack.push(cChar);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                
                if(cChar == ')' && stack.peek()!='('){
                    return false;
                }
                
                if(cChar == ']' && stack.peek()!='['){
                    return false;
                }
                
                if(cChar == '}' && stack.peek()!='{'){
                    return false;
                }
                
                stack.pop();
            }
            
        }
        
        if (stack.isEmpty())
			return true;
		else
		    return false;
    }
}