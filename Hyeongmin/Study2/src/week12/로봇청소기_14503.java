package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class 로봇청소기_14503 {
	static int d = 0;
	static int map[][];
	static int n, m;
	static boolean visit[][];
	static int dx[] = { 0, 1, 0, -1 }; // 북동남서
	static int dy[] = { -1, 0, 1, 0 };
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String temp[] = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);

		map = new int[n][m];
		visit = new boolean[n][m];

		temp = br.readLine().split(" ");

		int r = Integer.parseInt(temp[0]);
		int c = Integer.parseInt(temp[1]);
		d = Integer.parseInt(temp[2]);

		for (int i = 0; i < n; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}

		/*------------------input-------------*/

		clean(r, c);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (visit[i][j])
					count++;
		System.out.println(count);

	}

	public static void clean(int x, int y) {
		visit[x][y] = true; // 현재위치 청소

		int nextx = x;
		int nexty = y;

		for (int i = 0; i < 4; i++) {
			// 방향이동 왼쪽으로
			if (d == 0)
				d = 3;
			else
				d--;

			// 가야할 방향
			nextx = x + dy[d];
			nexty = y + dx[d];

			if (nextx < 0 || nexty < 0 || nextx >= n || nexty >= m)
				continue;

			// 방문하지않았고, 벽이아니면 이동
			if (!visit[nextx][nexty] && map[nextx][nexty] == 0) {
				clean(nextx, nexty);
				return;
			}

		}
		// 네방향 모두 청소 되어있거나 벽인경우 한칸 후진

		for (int i = 0; i < 4; i++) {
			// 방향이동 왼쪽으로
			if (d == 0)
				d = 3;
			else
				d--;

			// 후진1칸
			if (i == 1) {
				nextx = x + dy[d];
				nexty = y + dx[d];
			}
		}

		// 후진 방향을 방문했거나 벽이거나 맵을 넘어가면
		if (nextx < 0 || nexty < 0 || nextx >= n || nexty >= m)
			return;
		else if(map[nextx][nexty] == 1)
			return;
		else {
			clean(nextx, nexty);
			return;
		}

	}
}
