package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class DFS스페셜저지_16964 {

	static ArrayList<Integer> map[];
	static boolean visit[];
	static int count = 0;
	static int result[];
	
	static boolean check;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		map = new ArrayList[n + 1];

		for (int i = 0; i < n + 1; i++)
			map[i] = new ArrayList<Integer>();

		visit = new boolean[n + 1];

		for (int i = 0; i < n - 1; i++) {
			String temp[] = br.readLine().split(" ");

			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);

			map[x].add(y);
			map[y].add(x);
		}

		String temp[] = br.readLine().split(" ");
		result = new int[n];

		for (int i = 0; i < n; i++)
			result[i] = Integer.parseInt(temp[i]);
//		입력부 ----------------------------------------------- 
		
		if(result[0] != 1) {
			System.out.println(0);
			return;
		}
		
		dfs(1);
		
		if(check)
			System.out.println(0);
		else
			System.out.println(1);

		

	}

	static public void dfs(int index) {
		if (visit[index] || count==result.length)
			return;

		visit[index] = true;

		int next_token = result[count + 1];
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int a : map[index]) {
			if(!visit[a])
				list.add(a);
		}
		
		if(list.isEmpty())
			return;
		
		if(list.contains(next_token)) {
			count++;
			dfs(result[count]);
		}
		else
			check = true;
		
		
	}

}
