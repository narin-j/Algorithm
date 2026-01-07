class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int left = 1;
        int right = 100000;
        int answer = right;
        
        while(left <= right){
            int mid = (left+right)/2;
            if(canSolve(diffs, times, limit, mid)){
                answer = mid;
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
     private boolean canSolve(int[] diffs, int[] times, long limit, int level) {
        long total = 0;
         for(int i=0; i<diffs.length; i++){
             if(diffs[i] <= level){
                 total += times[i];
             } else {
                 long fail = diffs[i] - level;
                 long prev = (i==0) ? 0 : times[i-1];
                 total += fail * (times[i]+prev) + times[i];
             }
             if(total > limit) return false;
         }
         return true;
     }
}