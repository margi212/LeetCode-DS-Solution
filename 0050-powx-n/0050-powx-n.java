class Solution {
    public double myPow(double x, int n) {
        boolean isNegative = false;
        if(n<0){
            isNegative = true;
            n = n * (-1);
        }

        return isNegative?(1/solve(x,n)):solve(x,n);
    }

    private double solve(double x, int n){
        if(n==0){
            return 1;
        }

        if(n==1){
            return x;
        }

        double temp = solve(x,n/2); 
        if(n%2==0){
            return (temp*temp) ;
        }
        
        return (x*temp*temp);
    }
}