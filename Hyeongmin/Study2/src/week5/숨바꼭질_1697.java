package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class dot {
	int now;
	int before;

	dot() {

	}

	dot(int now, int before) {
		this.now = now;
		this.before = before;
	}
}

public class 见官怖龙_1697 {

	static int visit[] = new int[100001]; // default = 0;
	static int result[] = new int[100001];
	static ArrayDeque<dot> stage = new ArrayDeque<dot>();
	static int time = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int bro = -1;
		int me = -1;

		String temp[] = br.readLine().split(" ");
		me = Integer.parseInt(temp[0]); // 5
		bro = Integer.parseInt(temp[1]); // 17

		result[bro] = -1; // 档馒
		visit[me] = 0; // 矫累

		dot a = new dot(me, me);
		stage.offer(a);
		bfs();
		System.out.println(time);

	}

	public static void bfs() {

		while (!stage.isEmpty()) {
			dot temp = stage.poll();

			if (result[temp.now] == -1) {
				time = result[temp.before] + 1;
				return;
			}

			visit[temp.now] = 1; // 规巩贸府

			// 钮俊 持扁
			if (temp.now + 1 <= 100000 && visit[temp.now + 1] == 0) {
				dot a = new dot(temp.now + 1, temp.now);
				if (result[a.now] != -1) {
					result[a.now] = result[a.before] + 1;
					visit[a.now] = 1; // 规巩贸府
				}
				stage.offer(a);
			}
			if (temp.now - 1 >= 0 && visit[temp.now - 1] == 0) {
				dot a = new dot(temp.now - 1, temp.now);
				if (result[a.now] != -1) {
					result[a.now] = result[a.before] + 1;
					visit[a.now] = 1; // 规巩贸府
				}
				stage.offer(a);
			}
			if (temp.now * 2 <= 100000 && visit[temp.now * 2] == 0) {
				dot a = new dot(temp.now * 2, temp.now);
				if (result[a.now] != -1) {
					result[a.now] = result[a.before] + 1;
					visit[a.now] = 1; // 规巩贸府

				}
				stage.offer(a);
			}
		}

		return;
	}
}
