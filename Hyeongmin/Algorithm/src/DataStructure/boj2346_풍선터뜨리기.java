package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class boj2346_«≥º±≈Õ∂ﬂ∏Æ±‚ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Deque<int[]> queue = new ArrayDeque<int[]>();

		int number = Integer.parseInt(br.readLine());

		String line[] = br.readLine().split(" ");
		int index = 1;
		for (String a : line) {
			int temp[] = { index++, Integer.parseInt(a) };
			queue.offer(temp);
		}

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();

			bw.append(temp[0] + " ");
			
			if(queue.size()==1) {
				bw.append(queue.poll()[0] + " ");
				break;

			}
			if (temp[1] >= 0) {
				for (int i = 0; i < temp[1]-1; i++) {
					int move[] = queue.poll();
					queue.offer(move);
				}
			}
			else {
				for (int i = 0; i < Math.abs(temp[1]); i++) {
					int move[] = queue.pollLast();
					queue.offerFirst(move);
				}
			}
		}
		bw.flush();
	}

}
