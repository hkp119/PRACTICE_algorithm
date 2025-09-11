
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

 * */
public class baek_2667 {

	static char[][] map;
	static boolean [][] visited;
	static int N;
	static int[] dir_x = {0, 0, -1, 1};
	static int[] dir_y = {1, -1, 0, 0};
	static int count = 0;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		int result[];
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(map[j][i] == '0' || visited[j][i] == true) continue;
				count = 0;
				dfs(i, j);
				list.add(count);
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}
	
	static void dfs(int x, int y)
	{
		int nx, ny;
		if(x < 0 || x >= N || y < 0 || y >= N || map[y][x] == '0' || visited[y][x] == true) return;
		visited[y][x] = true;
		count++;

		for(int i = 0; i < dir_y.length; i++)
		{
			ny = y + dir_y[i];
			nx = x + dir_x[i];
			dfs(nx, ny);
		}
	}