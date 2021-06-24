package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class boj2164_Ä«µå2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int k = Integer.parseInt(br.readLine());
		
		Deque<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1;i<=k;i++) {
			queue.offer(i);
		}
		
		while(true) {
			if(queue.size()==1) {
				System.out.println(queue.peek());
				break;
			}
			
			queue.poll();
			int temp = queue.poll();
			queue.offer(temp);
		}
	}

}
