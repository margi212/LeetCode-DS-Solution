/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long start = 0;
        long end = n;
        
        int badV = -1;
        while(start <= end){
            int mid = (int)(start + (end-start)/2);
            if(isBadVersion(mid)){
                badV = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
  
        return badV;
    }
}