class Solution {
    public int[] solution(String s) {
        int zeroCount = 0;
        int binCnt = 0;
        
        while(!s.equals("1")){
            binCnt++;
            
            // 0 개수 세기
            int zeros = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '0'){
                    zeros++;
                }
            }
            zeroCount += zeros;
            
            // 0 제거 후 길이
            int length = s.length() - zeros;
            
            // 길이를 이진수로 변환
            s = Integer.toBinaryString(length);
        }
        
        int[] answer = {binCnt, zeroCount};
        return answer;
    }
}