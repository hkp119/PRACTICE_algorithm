// Programmers
// Link : https://school.programmers.co.kr/learn/courses/30/lessons/49994

/**
 * 문제 : 방문 길이
 * => 처음 걸어본 길의 합
 *  
 * Example)
 * 입력 : "ULURRDLLU"
 * 출력 : 7
 * 
 * U: 위쪽으로 한 칸 가기
 * D: 아래쪽으로 한 칸 가기
 * R: 오른쪽으로 한 칸 가기
 * L: 왼쪽으로 한 칸 가기
**/

/**
 * Set을 이용하여, 좌표값을 저장
 * Set 배열의 길이를 도출
 */
import java.util.Set;
import java.util.HashSet;

public class pro_49994
{
    	public static void main(String[] args) {

        System.out.println("hello");
        System.out.println(problem("ULURRDLLU"));
    }

    public static int problem(String path)
    {
    	int x = 0; int y = 0;
    	Set<String> set = new HashSet<>();
        for(int i = 0; i < path.length(); i++)
        {
          	int nx = x; int ny = y;

            if(path.charAt(i) == 'U')
            {
                if(y == 5) continue;
                else y++;
            }
            if(path.charAt(i) == 'D')
            {
            	if(y == -5) continue;
            	else y--;
            }
            if(path.charAt(i) == 'L')
            {
            	if(x == -5) continue;
            	else x--;
            }
            if(path.charAt(i) == 'R')
            {
            	if(x == 5) continue;
            	else x++;
            }
    		set.add("(" + nx + "," + ny + ") -> " + "(" + x + "," + y + ")");
            set.add("(" + x + "," + y + ") -> " + "(" + nx + "," + ny + ")");
        }

        // for(String str : set)
        // 	System.out.println(str);
        return set.size() / 2;
    }
}
