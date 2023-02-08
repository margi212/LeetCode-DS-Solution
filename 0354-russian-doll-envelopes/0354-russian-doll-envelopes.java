class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //sort envelopes by envelopes[i][0] in ascending order, and envelopes[i][1] in descending order
        //by extracting the height of each envelope, the problem can be changed to the Longest Increasing Subsequence
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return b[1] - a[1];
                else
                    return a[0] - b[0];
            }
        });
      
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }
        
        return LIS(height);
    }
    
    //binary search method to find Longest Increasing Subsequence
    int LIS(int[] height) {
        int top[] = new int[height.length];
        int piles = 0;
        for (int i = 0; i < height.length; i++) {
            int poker = height[i];
            int left = 0;
            int right = piles;
            while(left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= poker)
                    right = mid;
                else
                    left = mid + 1;
            }
            if (left == piles)
                piles++;
            top[left] = poker;
        }
        return piles;
    }
}