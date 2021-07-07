package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class boj1966_프린터큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			Queue<int[]> queue = new LinkedList<int[]>();
			
			String line[] = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int k = Integer.parseInt(line[1]);
			
			String importance[] = br.readLine().split(" ");
			
			//각 문서의 중요도
			for(int j=0;j<n;j++) {
				int data[] = {j,Integer.parseInt(importance[j])};
				queue.offer(data);
			}
			
			int count=0;
			while(!queue.isEmpty()) {
				boolean check = true;

				//중요도 비교
				int temp[] = queue.poll();	//temp : index, importance
				
				for(int value[] : queue) {
					if(temp[1]<value[1]) {
						queue.offer(temp);
						check = false;
						break;
					}
				}
				
				//빠지는 경우
				if(check) {
					count++;

					if(temp[0]==k) {
						bw.append(count+"\n");
						break;
					}
				}
			}
		}
		
		bw.flush();
	}

}
