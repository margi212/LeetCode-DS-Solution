class Solution {
    public int mirrorReflection(int p, int q) {
        //https://leetcode.com/problems/mirror-reflection/discuss/2377070/Pseudocode-Explain-Why-Odd-and-Even-Matter
        while( p%2 == 0 && q%2 == 0){
            p=p/2;
            q=q/2;
        }
        
        if (p%2 == 0)
	        return 2;
	
	    if (q%2 == 0)
		    return 0;
	
	    return 1;
            
    }
}