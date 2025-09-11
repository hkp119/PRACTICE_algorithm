import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();

        // 배열 초기화
        for(int i = 0; i < want.length; i++)
            map.put(want[i], number[i]);
        
        int sum = 0;
        for(int i = 0; i <= (discount.length - 10); i++)
        {
            Map<String, Integer> temp = new HashMap<>(map);
            for(int j = 0; j < 10; j++)
            {
                String item = discount[j+i];
                if(!temp.containsKey(item))
                    continue;
                int num = temp.get(item);

                if(num != 0)
                    temp.put(item, num - 1);
            }
            
            sum = 0;
            for(int value : temp.values())
                sum += value;
            
            if(sum == 0)
                answer++;
            
        }
        
        return answer;
    }
}