class Solution {
    public int bestClosingTime(String customers) {
        int ans = 0;
        int counter = 0;
        int n = customers.length();
       
        for(int i=0;i<n;i++){
            if(customers.charAt(i) == 'N'){
                counter++;
            } else {
                counter--;
                
                if(counter < 0){
                    ans = i+1;
                    counter = 0;
                }
            }
        }
        
        return ans;
    }
}