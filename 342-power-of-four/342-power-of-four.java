class Solution {
    public boolean isPowerOfFour(int n) {
        
        if(n==1)
            return true;
        else if(n==0)
            return false;
        else
            return (n%4==0)&&(isPowerOfFour(n/4));
    }
}