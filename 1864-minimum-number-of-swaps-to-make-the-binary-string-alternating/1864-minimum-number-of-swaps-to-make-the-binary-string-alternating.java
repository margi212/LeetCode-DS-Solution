class Solution {
    /*
    If difference between count of ones and zeros is > 1 then it's impossible to make string alternative, so we return -1
    
If number of zeros > ones, it mean zeros has to be at indexes 0, 2, 4.... So in case we need to count how many zeros are not even places, In other words, how many zeros are at odd places.

If number of ones > zeros, Here we need to check the same things as step two.

In the last if both counts are equals ones == zeros. Move either zero or one which is least displaced. which is min of all four values.
*/
    public int minSwaps(String s) {
           int[] onesAtPlaces = new int[2];    // 0: even, 1: odd
        int[] zerosAtPlaces = new int[2];    // 0: even, 1: odd
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '1') {
                onesAtPlaces[i%2]++;
            }
            else {
                zerosAtPlaces[i%2]++;
            }
        }

        int ones = onesAtPlaces[0] + onesAtPlaces[1];
        int zeros = zerosAtPlaces[0] + zerosAtPlaces[1];

        // If diff > 1 then we cannot really make string alternative
        if(Math.abs(ones-zeros) > 1) {
            return -1;
        }
        else if(ones > zeros) {   // if ones > zeros, onces has to at even places 0, 2, 4...
            return onesAtPlaces[1];
        }
        else if(ones < zeros) {  // if zeros > ones, zeros has to at even places 0, 2, 4...
            return zerosAtPlaces[1];
        }
        else {
            // if boths ones and zeros as requal, see which one is least out of order
            return Math.min(
                        Math.min(zerosAtPlaces[0], zerosAtPlaces[1]), 
                        Math.min(onesAtPlaces[0], onesAtPlaces[1])
                );
        }
    }
}