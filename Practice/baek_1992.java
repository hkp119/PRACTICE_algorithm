
// 백준
// Link : https://www.acmicpc.net/problem/1992
/**
 * 문제 : 쿼드트리
 * => 분할과 정복 형태, 재귀 활용하여 문제 풀기 (사분면)
 *  
 * Example)
 * 입력 : 8
 * 출력
    11110000
    11110000
    00011100
    00011100
    11110000
    11110000
    11110011
    11110011
 * 
 * 자료구조 => 재귀 이용
**/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		// map = new char[N][N]; // 공간 낭비 발생 <= toCharArray
		map = new char[N][];
		for(int i = 0; i < N; i++)
		{
			map[i] = br.readLine().toCharArray(); 
		}
		
		divide(N, 0, 0);
		System.out.println(sb);	
	}
	static boolean check(int x, int y, int n)
	{
		char ch = map[y][x]; // 검사 시작 위치의 문자
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(ch != map[i+y][j+x])
					return false;
			}
		}
		return true;
	}
	public static void divide(int n, int x, int y)
	{

		if(check(x, y, n))
		{
			sb.append(map[y][x]); 
			return;
		}
		else
		{
			sb.append("(");
			divide(n/2, x, y);
			divide(n/2, x + n/2, y);
			divide(n/2, x, y + n/2);
			divide(n/2, x + n/2, y + n/2);
			sb.append(")");			
		}
	}
}
