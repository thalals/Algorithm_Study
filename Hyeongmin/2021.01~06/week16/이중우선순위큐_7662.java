package week16;

import java.io.*;
import java.util.*;

class data implements Comparable<data> {
	long data;
	int index;

	data(long data, int index) {
		this.data = data;
		this.index = index;
	}

	@Override
	public int compareTo(data o) {
		if (this.data > o.data)
			return 1;

		return -1;
	}
}

public class 이중우선순위큐_7662 {
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			int k = Integer.parseInt(br.readLine());

			PriorityQueue<data> maxheap = new PriorityQueue<data>(Collections.reverseOrder());
			PriorityQueue<data> minheap = new PriorityQueue<data>();

			visit = new boolean[k];
			int count_idx = 0;

			String temp[];
			for (int i = 0; i < k; i++) {
				temp = br.readLine().split(" ");
				// Insert
				if (temp[0].equals("I")) {
					data tdata = new data(Long.parseLong(temp[1]), count_idx++);
					maxheap.add(tdata);
					minheap.add(tdata);
				}
				// Delete data
				else {
					if (maxheap.isEmpty() || minheap.isEmpty()) {

						continue;
					}
					// 최대값 삭제
					if (Integer.parseInt(temp[1]) == 1) {

						// 실질적인 데이터가 하나이거나 중복된 데이만 존재할 때..?
						while (true) {
							if(maxheap.isEmpty() || minheap.isEmpty())
								break;
							if (maxheap.peek().data == minheap.peek().data) {
								data tdata = maxheap.poll();
								minheap.poll();
								// 삭제된 적이 있으면 하나더
								if (visit[tdata.index])
									continue;
								visit[tdata.index] = true; // 삭제된 데이터는 방문 처리
								break;
							} else {
								data tdata = maxheap.poll();
								if (visit[tdata.index])
									continue;
								visit[tdata.index] = true; // 삭제된 데이터는 방문 처리
								break;
							}
						}

					} else {
						while (true) {
							if(maxheap.isEmpty() || minheap.isEmpty())
								break;
							if (maxheap.peek().data == minheap.peek().data) {
								data tdata = maxheap.poll();
								minheap.poll();
								if (visit[tdata.index])
									continue;
								visit[tdata.index] = true; // 삭제된 데이터는 방문 처리
								break;
							} else {
								data tdata = minheap.poll();
								if (visit[tdata.index])
									continue;
								visit[tdata.index] = true; // 삭제된 데이터는 방문 처리
								break;
							}
						}
					}
				}
			}
			if (maxheap.isEmpty() || minheap.isEmpty()) {
				sb.append("EMPTY\n");
			}

			else {
				while (!maxheap.isEmpty()) {
					data tt = maxheap.poll();
					// 삭제된적 없었던 최댓값이라면
					if (!visit[tt.index]) {

						sb.append(tt.data + " ");
						break;
					}
				}

				while (!minheap.isEmpty()) {
					data tt = minheap.poll();
					// 삭제된적 없었던 최소값이라면
					if (!visit[tt.index]) {
						sb.append(tt.data + "\n");
						break;
					}
				}
			}
			t--;
		}
		if (sb.length() == 0)
			System.out.println("EMPTY\n");
		else
			System.out.println(sb);

	}

}
