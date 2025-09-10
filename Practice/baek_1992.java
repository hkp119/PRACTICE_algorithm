
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
	static int[][] array;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		array = new int[N][N];
		for(int i = 0; i < N; i++)
		{
			String str = br.readLine();
			for(int j = 0; j < N; j++)
				array[i][j] = str.charAt(j) - '0';
		}
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
		int x = 0, y = 0;
		divide(N, x, y);
		System.out.println(sb);
		
	}

	public static void divide(int n, int x, int y)
	{
		int sum = 0;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
				sum += array[i+y][j+x];
		}
		
		if(sum == 0)
		{
			sb.append("0"); return;
		}
		else if (sum == n*n)
		{
			sb.append("1"); return;
		}
	
		sb.append("(");
		divide(n/2, x, y);
		divide(n/2, x + n/2, y);
		divide(n/2, x, y + n/2);
		divide(n/2, x + n/2, y + n/2);
		sb.append(")");
	}
}
