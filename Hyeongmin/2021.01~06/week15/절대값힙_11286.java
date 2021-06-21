package week15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class 절대값힙_11286 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> Reverse_pq = new PriorityQueue<Integer>(Collections.reverseOrder());	//음수
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();	//양수
		
		for(int i=0;i<n;i++) {
			int key = Integer.parseInt(br.readLine());
			
			if(key==0) {	//출력
				if(pq.size()==0 && Reverse_pq.size()==0)
					bw.append(0+"\n");
				else if(pq.size()>0 && Reverse_pq.size()>0) {
					if(pq.peek()<Math.abs(Reverse_pq.peek()))
						bw.append(pq.poll()+"\n");
					else if(pq.peek()>Math.abs(Reverse_pq.peek()))
						bw.append(Reverse_pq.poll()+"\n");
					else
						bw.append(Reverse_pq.poll()+"\n");
				}
				else if(pq.size()>0) {
					bw.append(pq.poll()+"\n");
				}
				else
					bw.append(Reverse_pq.poll()+"\n");
			}
			
			else if(key>0)
				pq.add(key);
			
			else
				Reverse_pq.add(key);
		}
		
		bw.flush();
		
		
	}

}
