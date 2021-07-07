/* 힙은 우선순위 큐를 이용
 * 역 정렬은 Collections.reversOrders
 */
package DataStructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj11279_최대힙 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		while(n-->0) {
			int input = Integer.parseInt(br.readLine());
			if(input ==0) {
				if(heap.isEmpty())
					sb.append(input+"\n");
				else
					sb.append(heap.poll()+"\n");
			}
			else
				heap.offer(input);
		}
		
		System.out.println(sb.toString());
	}

}
