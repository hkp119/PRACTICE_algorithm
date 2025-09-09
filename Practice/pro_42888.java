// Programmers
// Link : https://school.programmers.co.kr/learn/courses/30/lessons/42888

/**
 * 문제 : 오픈채팅방
 * => ID 생성, 삭제, 변경 처
 *  
 * Example)
 * 입력 : ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
 * 출력 : ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
 * 
 * 입장 : Enter
 * 퇴장 : Leave
 * 변경 : Change (닉네임 변경), 출력 X
**/

/**
 * HashMap을 이용하여 id 값 저장 (데이터베이스 처럼 이용)
 * 이후 출력 처리 
 * 시간 복잡도 : O(N)
 */

 
import java.util.HashMap;
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> hashMap = new HashMap<>();
        
        for(String person : record)
        {
            String[] arr = person.split(" ");
            if(arr[0].equals("Enter") || arr[0].equals("Change"))
                hashMap.put(arr[1], arr[2]);
        }

        List<String> out = new ArrayList<>();
        for(int i = 0 ; i < record.length; i++)
        {
            String res = "";
            String[] arr = record[i].split(" ");
            String id = hashMap.get(arr[1]);
            switch(arr[0])
            {
                case "Enter":
                    res = id + "님이 들어왔습니다."; break;
                case "Leave":
                    res = id + "님이 나갔습니다."; break;
                default:
                    break;
            }
            if(res.length() > 0)
                out.add(res);
        }
        
        // 0 으로 적어주면 알아서 리스트 크기만큼 채워줌 
        return out.toArray(new String[0]);
    }
}