import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
    
        int al = A.length-1;
        int bl = B.length-1;
       while(al >= 0 && bl >= 0)
       {
           if(A[al] >= B[bl])
               al--;
           else
           {
               answer++;
               al--; bl--;               
           }
       }
        return answer;
    }
}