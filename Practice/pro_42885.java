/**
 * 2023-08-16
 * 프로그래머스 - 구명보트
 * 
 * 투포인터 이용
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/42885
 * 
 * 시간복잡도: O(N log N) => 정렬 때문
 * 공간복잡도: O(N)
 */

import java.util.Arrays;

public class pro_42885 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right)
        {
            if((people[left] + people[right]) <= limit)
            {
                left++;
                right--;
            }
            else
            {
                right--;
            }
            answer += 1;
        }
        
        
        return answer;
    }
}
