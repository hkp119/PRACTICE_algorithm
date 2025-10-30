class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int data : arr)
        {
            answer += data;
        }
        return answer / arr.length;
    }
}