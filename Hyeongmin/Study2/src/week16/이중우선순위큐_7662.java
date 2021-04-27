package week16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

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
						if (maxheap.peek().data == minheap.peek().data) {
							data tdata = maxheap.poll();
							minheap.poll();

							visit[tdata.index] = true; // 삭제된 데이터는 방문 처리
						} else {
							data tdata = maxheap.poll();
							visit[tdata.index] = true; // 삭제된 데이터는 방문 처리
						}

					} else {
						if (maxheap.peek().data == minheap.peek().data) {
							data tdata = maxheap.poll();
							minheap.poll();
							visit[tdata.index] = true; // 삭제된 데이터는 방문 처리
						} else {
							data tdata = minheap.poll();
							visit[tdata.index] = true; // 삭제된 데이터는 방문 처리

						}
					}
				}
			}
			if (maxheap.isEmpty() || minheap.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				while (true) {
					data tt = maxheap.poll();
					// 삭제된적 없었던 최댓값이라면
					if (!visit[tt.index]) {
						sb.append(tt.data + " ");
						break;
					}
				}

				while (true) {
					data tt = minheap.poll();
					// 삭제된적 없었던 최댓값이라면
					if (!visit[tt.index]) {
						sb.append(tt.data + "\n");
						break;
					}
				}
			}
			t--;
		}
		System.out.println(sb);

	}

	// 동기화.. 시간초과.. 안나나..
	public static void DongGiwha(PriorityQueue<Integer> base, PriorityQueue<Integer> copy) {
		copy.clear();

		copy = base;
//		Iterator<Integer> list = base.iterator();
//		
//		while(list.hasNext())
//			copy.add(list.next());
	}

}
