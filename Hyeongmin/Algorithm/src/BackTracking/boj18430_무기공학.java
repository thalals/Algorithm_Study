package BackTracking;

import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj18430_무기공학 {
	static int n, m;
	static int[][] map;
	static boolean visit[][];
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String temp[] = br.readLine().split(" ");

		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);

		map = new int[n + 1][m + 1];

		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(temp[j]);
		}

		visit = new boolean[n + 1][m + 1];

		backtracking(0, 0);

		System.out.println(result);
	}

	public static void backtracking(int cnt, int sum) {
		// 다 돌음
		if (cnt == n * m) {
			if (result < sum)
				result = sum;
			return;
		}

		int x = cnt / m;
		int y = cnt % m;

		if (!visit[x][y]) {
			// 2 1
			// 1
			if (x + 1 < n && y + 1 < m && !visit[x + 1][y] && !visit[x][y + 1]) {
				visit[x][y] = true;
				visit[x + 1][y] = true;
				visit[x][y + 1] = true;

				int tsum = sum + 2 * (map[x][y]) + map[x + 1][y] + map[x][y + 1];
				backtracking(cnt + 1, tsum);

				visit[x][y] = false;
				visit[x + 1][y] = false;
				visit[x][y + 1] = false;
			}
			// 1 2
			//   1
			if (x + 1 < n && y - 1 >= 0 && !visit[x + 1][y] && !visit[x][y - 1]) {
				visit[x][y] = true;
				visit[x + 1][y] = true;
				visit[x][y - 1] = true;

				int tsum = sum + 2 * (map[x][y]) + map[x + 1][y] + map[x][y - 1];
				backtracking(cnt + 1, tsum);

				visit[x][y] = false;
				visit[x + 1][y] = false;
				visit[x][y - 1] = false;
			}
			//   1
			// 1 2
			if (x - 1 >= 0 && y - 1 >= 0 && !visit[x - 1][y] && !visit[x][y - 1]) {
				visit[x][y] = true;
				visit[x - 1][y] = true;
				visit[x][y - 1] = true;

				int tsum = sum + 2 * (map[x][y]) + map[x - 1][y] + map[x][y - 1];
				backtracking(cnt + 1, tsum);

				visit[x][y] = false;
				visit[x - 1][y] = false;
				visit[x][y - 1] = false;
			}
			// 1
			// 2 1
			if (x - 1 >= 0 && y + 1 < m && !visit[x - 1][y] && !visit[x][y + 1]) {
				visit[x][y] = true;
				visit[x - 1][y] = true;
				visit[x][y + 1] = true;

				int tsum = sum + 2 * (map[x][y]) + map[x - 1][y] + map[x][y + 1];
				backtracking(cnt + 1, tsum);

				visit[x][y] = false;
				visit[x - 1][y] = false;
				visit[x][y + 1] = false;
			}

		}
		backtracking(cnt+1, sum);
	}

}
