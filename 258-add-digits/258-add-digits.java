class Solution {
    public int addDigits(int num) {
        while(num>=10){
            num = callAddDigit(num);
        }
        
        return num;
    }
    
    private int callAddDigit(int num){
        if(num==0)
           return 0;
        
        return (num % 10) + callAddDigit(num/10);
    }
}