class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int ratio = minutesToTest/minutesToDie;
        int count = 0;
        while(Math.pow(ratio+1,count)< buckets){
            count++;
        }
        
        return count;
    }
}