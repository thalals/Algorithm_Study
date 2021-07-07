package week15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class 가운데를말해요_1655 {

	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
		
		for(int i=0;i<n;i++) {
			int key = Integer.parseInt(br.readLine());
			
			if(i%2==0) 
				maxheap.add(key);
			else
				minheap.add(key);
			
			//maxheep 왼쪽 minheep오른쪽
			if(i>0 && maxheap.peek() > minheap.peek()) {
				int temp = minheap.poll();
                minheap.offer(maxheap.poll());
                maxheap.offer(temp);
			}
			
			bw.append(maxheap.peek()+"\n");
		}
		bw.close();
		br.close();
	}


}
