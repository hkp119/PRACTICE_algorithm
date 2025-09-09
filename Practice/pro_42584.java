
// Programmers
// Link : https://school.programmers.co.kr/learn/courses/30/lessons/42584

/**
 * 문제 : 주식가격
 * => 주가 변동 후 처리 
 *  
 * Example)
 * 입력 : [1, 2, 3, 2, 3]	
 * 출력 : [4, 3, 1, 1, 0]
 * 
 * 자료구조 => 스택 이용
**/

// price 값이 stack의 peek 값보다 더 크면 push
// price 값이 stack의 peek 값보다 더 작으면 pop
// 값은 pair {index, value} 형태로 저장
// return을 위한 배열 (prices.length) 생성

// 1 -> stack {1, 1}
// 2 -> stack {1, 1}, {2, 2}
// 3 -> stack {1, 1}, {2, 2}, {3, 3}
// 2 -> stack pop 3 => stack {1, 1}, {2, 2} => 3이 pop 되므로, index 3의 값을 갱신
// 3 -> stack {1, 1}, {2, 2}, {2, 4}, {3, 5}

// pop {3, 5} => index 5의 값을 갱신 (최대치 5 - 5) 0
// pop {2, 4} => index 4의 값을 갱신 (최대치 5 - 4) 1
// pop {2, 2} => index 2의 값을 갱신 (최대치 5 - 2) 3
// pop {1, 1} => index 1의 값을 갱신 (최대치 5 - 1) 4

// return array 반환

import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
		Deque<int[]> stack = new ArrayDeque<int[]>();
		
		for(int i = 0; i < prices.length; i++)
		{
			while (!stack.isEmpty() && stack.peek()[0] > prices[i]) // 연속적으로 가격이 떨어질 수 있음을 상정
			{
				int[] data = stack.poll();
				answer[data[1]] = i - data[1];
			}
			stack.push(new int[] {prices[i], i});
		}
		
		int max_day = prices.length;
		while(!stack.isEmpty())
		{
			int[] data = stack.poll();
			answer[data[1]] = max_day - data[1] - 1;
		}
		return answer;
    }
}