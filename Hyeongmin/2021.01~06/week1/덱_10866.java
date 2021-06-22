package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class µ¦_10866 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Deque<Integer> dq = new ArrayDeque<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		
		int back_num = -1;
		
		for(int i=0;i<n;i++) {
			String key[] = br.readLine().split(" ");
			
			switch (key[0]) {
			case "push_front":
				if(dq.isEmpty()) {
					dq.offerFirst(Integer.parseInt(key[1]));
				
					back_num = Integer.parseInt(key[1]);
				}
				else
					dq.offerFirst(Integer.parseInt(key[1]));
				break;
			
			case "push_back":
				
				dq.offer(Integer.parseInt(key[1]));
				
				back_num = Integer.parseInt(key[1]);
				
				break;
				
			case "pop_front":
				if(dq.isEmpty()) {
					bw.write(-1+"\n");
					break;
				}				
				int re = dq.poll();
				
				bw.write(re+"\n");

				break;
				
			case "pop_back":
				if(dq.isEmpty()) {
					bw.write(-1+"\n");
					break;
				}				
				
				int re1 = dq.pollLast();
			
				bw.write(re1+"\n");

				break;
				
			case "size":
				bw.write(dq.size()+"\n");

				break;
				
			case "empty":
				if(dq.isEmpty()) {
					bw.write(1+"\n");
					break;
				}
				else {
					bw.write(0+"\n");

					break;					
				}
				
			case "back":
				if(dq.isEmpty()) {
					bw.write(-1+"\n");

					break;
				}
				bw.write(dq.peekLast()+"\n");

				break;
				
			case "front":				
				if(dq.isEmpty()) {
					bw.write(-1+"\n");

					break;
				}
				
				int re2 = dq.peek();
				bw.write(re2+"\n");

				break;
			}
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
