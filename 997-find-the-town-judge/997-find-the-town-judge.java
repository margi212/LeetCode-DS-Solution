class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        
        for(int[] cTrust:trust){
            int a = cTrust[0];
            int b = cTrust[1];
            
            inDegree[b] += 1;
            outDegree[a] += 1;
        }
        
        for(int cPeople = 1;cPeople<=n;cPeople++){
            if(inDegree[cPeople] == n-1 && outDegree[cPeople] == 0){
                return cPeople;
            }
        }
        
        return -1;
    }
}