class Solution {
    
    public final String[] KEYWORDS={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<String>();
        
        if(digits.isEmpty())
            return answer;
        generateCombination(digits,0,"",answer);
        return answer;
    }
    
    private void generateCombination(String digits,int currentIndex,String cVal,List<String> answer) {
        
        if(currentIndex>=digits.length()){
            answer.add(cVal);
            return;
        }
        
        Character ch = digits.charAt(currentIndex);
        String letters = KEYWORDS[ch-'0'];
        
        for(int i=0;i<letters.length();i++){
            generateCombination(digits,currentIndex+1,cVal+letters.charAt(i),answer);
        }
        
        return;
    }
}