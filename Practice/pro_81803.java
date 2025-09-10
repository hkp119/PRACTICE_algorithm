// 표 편집 (7:30AM~)
// U X (up, x칸 위)
// D X (down, x칸 아래)
// C (현재 선택된 행 삭제 후 바로 아래 행 선택. 마지막인경우 바로 윗 행 선택)
// Z 가장 최근에 삭제된 행을 원래대로 복구. 현재 선택된 행은 유지
// 삭제 되지 않은 행은 "O", 삭제된 행은 "X"

// n : 처음 표의 행 개수
// k : 선택된 행의 위치 

// How to ?
// List를 pair로 관리, index 저장. (=> index로 삭제 여부 판별)
// Random access가 가능해야하므로, ArrayList를 사용 
// -> 효율은? 어떤게 제일 좋으려나.. 

import java.util.*;

public class pro_81803 {
    
    public String solution(int n, int k, String[] cmd) {
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
            list.add(i);
        
        int lastData = 0;
        int cmdNum = 0;
        String lastCmd = "";
        for(String s : cmd)
        {
            String str[] = s.split(" ");
            cmdNum = 0;
            
            if(str.length == 2)
                cmdNum = Integer.parseInt(str[1]);
            
            switch(str[0])
            {
                case "D":
                    k = ((k + cmdNum) > (list.size() - 1)) ? list.size() - 1 : k + cmdNum;
                    break;
                case "U":
                    k = ((k - cmdNum) < 0) ? 0 : k - cmdNum;
                    break;
                case "C":
                    if(!list.isEmpty())
                    {
                        lastData = list.get(k);
                        list.remove(k);    
                        
                        if(!list.isEmpty() && k == list.size())
                            k = list.size() - 1;
                    }
                    break;
                case "Z":
                    list.add(k, lastData);
                    break;
                default:
                    return "";
            }     
            if(!str[0].equals("C"))
                lastData = list.get(k);
        }
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int data : list)
        {
            if(idx == data)
            {
                sb.append("O"); 
                idx++;                
            }
            else
            {
                while(idx != data)
                {
                    sb.append("X");
                    idx++;
                }                
            }
        }
            
        return sb.toString();
    }
}
