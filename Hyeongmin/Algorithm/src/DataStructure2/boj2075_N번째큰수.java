// 우선순위 큐 내림차순 이용
package DataStructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj2075_N번째큰수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		
		int t = n;
		String temp[] = new String[n];
		
		PriorityQueue<Integer> list = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		while(t-->0) {
			temp = br.readLine().split(" ");
			for(String a : temp)
				list.add(Integer.parseInt(a));
		}
		
		while(n-->1)
			list.poll();
		
		System.out.println(list.poll());
	}

}
