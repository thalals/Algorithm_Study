package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class dot1 {
	int now;
	int before;

	dot1() {

	}

	dot1(int now, int before) {
		this.now = now;
		this.before = before;
	}
}

public class 숨바꼭질3_13549 {
	static int visit[] = new int[100001]; // default = 0;
	static int result[] = new int[100001];
	static ArrayDeque<dot1> stage = new ArrayDeque<dot1>();
	static ArrayList<Integer> time = new ArrayList<Integer>();
	static int bro = -1;
	static int me = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String temp[] = br.readLine().split(" ");
		me = Integer.parseInt(temp[0]); // 5
		bro = Integer.parseInt(temp[1]); // 17

		result[bro] = -1; // 도착
		visit[me] = 0; // 시작

		dot1 a = new dot1(me, me);
		stage.offer(a);
		bfs();
		Collections.sort(time);
		System.out.println(time.get(0));

	}

	public static void bfs() {

		while (!stage.isEmpty()) {
			dot1 temp = stage.poll();

			if (result[temp.now] == -1) {
				time.add(result[temp.before] + 1);
				continue;
//				return;
			}

			visit[temp.now] = 1; // 방문처리

			// 큐에 넣기
			if (temp.now * 2 <= 100000 && visit[temp.now * 2] == 0) {
				dot1 a = new dot1(temp.now * 2, temp.now);
				if (result[a.now] != -1) {
					result[a.now] = result[a.before];
					visit[a.now] = 1; // 방문처리

				}
				// *2일 때 도착했으면
				else {
					time.add(result[a.before]);
					continue;
				}
				stage.offer(a);
			}

			// +
			if (temp.now + 1 <= 100000 && visit[temp.now + 1] == 0||temp.now +1  <=100000 && result[temp.now+1] > result[temp.now]+1) {
				dot1 a = new dot1(temp.now + 1, temp.now);
				if (result[a.now] != -1) {
					result[a.now] = result[a.before] + 1;
					visit[a.now] = 1; // 방문처리
				}

				stage.offer(a);
			}

			// -
			if (temp.now - 1 >= 0 && visit[temp.now - 1] == 0 ||temp.now - 1 >= 0 && result[temp.now-1] > result[temp.now]+1) {
				dot1 a = new dot1(temp.now - 1, temp.now);
				if (result[a.now] != -1) {
					result[a.now] = result[a.before] + 1;
					visit[a.now] = 1; // 방문처리
				}
				stage.offer(a);
			}

		}

		return;
	}
}
