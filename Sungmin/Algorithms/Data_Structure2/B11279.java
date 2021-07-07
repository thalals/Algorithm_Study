/*
 * 우선순위 큐를 반대로 사용하게 되면 자료구조 상 최대 힙 형태를 구현할 수 있다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class B11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(input.readLine());
		for(int i=0;i<n;i++) {
			int x=Integer.parseInt(input.readLine());
			if(x==0) {//상위 출력 및 제거
				if(queue.isEmpty()) sb.append("0"+"\n");
				else sb.append(queue.poll()+"\n");
			}
			else {
				queue.add(x);
			}
		}
		System.out.print(sb);
		input.close();
	}
}
