/*
* 문제 : 기능개발
- 각 기능의 개발 속도가 다름
- 기능 개발의 순서는 없지만, 배포는 작업순으로 수행됨
- 작업의 progress와 speeds가 주어짐.
- 각 배포마다 몇개의 기능이 배포되는지를 반환.
*/

import java.util.*;

class pro_42586{
    public int[] solution(int[] progresses, int[] speeds) {
        int pastTime = 0;
        int taskIdx = -1;
        Map<Integer, Integer> array = new HashMap<>();
        for(int i = 0; i < progresses.length; i++)
        {
            int taskTime = (100 - progresses[i]) / speeds[i];
            if(pastTime < taskTime) // 배포
                array.put(++taskIdx, 1);
            else // 병행 수행 (같이 배포)
                array.put(taskIdx, array.get(taskIdx)+1);                

            if(pastTime < taskTime)
                pastTime = taskTime;                
        }   
        
        taskIdx = -1;
        int[] answer = new int[array.size()];
        for(int entry : array.values())
            answer[++taskIdx] = entry;
        
        return answer;
    }
}