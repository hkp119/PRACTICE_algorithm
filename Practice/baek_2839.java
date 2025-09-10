/*
 * 2938. 설탕배달
 * https://www.acmicpc.net/problem/2839
 * 
 * 알고리즘 : greedy
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baek_2839 {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
    
        int cnt = 0;
        while(N >= 0)
        {
            if(N % 5 == 0)
            {
                cnt += (N / 5);
                System.out.println(cnt);
                return;
            }
            N -= 3;
            cnt++;
        }

        if(N == 0)
            System.out.println(cnt);
        else
            System.out.println(-1);
    }
}
