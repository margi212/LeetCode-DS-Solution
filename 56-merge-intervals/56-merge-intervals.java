class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        
        int[] prev = list.get(0);
        
        for(int i=0;i<intervals.length;i++){
            int[] current = intervals[i];
            if(current[0]<=prev[1]){
                prev[1] = Math.max(current[1],prev[1]);
            }else{
                list.add(current);
                prev = current;
            }
        }
        
        return list.toArray(new int[list.size()][2]);
    }
}