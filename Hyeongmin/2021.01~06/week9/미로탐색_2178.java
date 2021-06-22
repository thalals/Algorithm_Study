package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class ¹Ì·ÎÅ½»ö_2178 {

	static int[][] visit;
	static int map[][];
	static int result = -1;

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int n, m;

	static Deque<int[]> dqlist = new ArrayDeque<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String temp[] = br.readLine().split(" ");

		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);

		visit = new int[n + 1][m + 1];
		map = new int[n + 1][m + 1];

		for (int i = 0; i < n; i++) {
			temp = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		/*--------------- input -----------------*/
		int e[] = { 0, 0 };
		dqlist.offer(e);
		bfs();

		System.out.println(result+1);

	}

	public static void bfs() {

		while (!dqlist.isEmpty()) {
			int add[] = dqlist.poll();

			if (add[0] == m - 1 && add[1] == n - 1) {
				result = visit[add[1]][add[0]];
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nextx = add[0] + dx[i];
				int nexty = add[1] + dy[i];

				if (nextx < 0 || nextx >= m || nexty < 0 || nexty >= n)
					continue;
				else if (visit[nexty][nextx] == 0 && map[nexty][nextx] == 1) {
					int ddd[] = { nextx, nexty };
					dqlist.offer(ddd);
					visit[nexty][nextx] = visit[add[1]][add[0]] + 1;
				}
			}
		}
	}
}
