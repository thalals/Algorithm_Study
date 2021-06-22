package week15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class √÷¥Î»¸_11279 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i=0;i<n;i++) {
			int key = Integer.parseInt(br.readLine());
			
			if(key==0) {
				if(pq.size()==0)
					bw.append(0+"\n");
				else
					bw.append(pq.poll()+"\n");
			}
			else
				pq.add(key);
		}
		
		bw.flush();
	}

}
