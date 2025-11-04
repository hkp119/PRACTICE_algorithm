import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> s = new HashMap<>();
        
        for(int i = 0; i < completion.length; i++)
        {
            if(s.containsKey(completion[i]))
                s.put(completion[i], s.get(completion[i]) + 1);
            else
                s.put(completion[i], 1);
        }
        
        for(int i = 0; i < participant.length; i++)
        {
            if(!s.containsKey(participant[i]))
                return participant[i];
            if(s.get(participant[i]) == 1)
                s.remove(participant[i]);
            else
                s.put(participant[i], s.get(participant[i]) - 1);
        }
        
        return "";
    }
}