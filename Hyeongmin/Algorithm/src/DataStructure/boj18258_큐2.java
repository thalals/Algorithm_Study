package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class boj18258_ť2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int k = Integer.parseInt(br.readLine());
		
		Deque<Integer> queue = new LinkedList<Integer>();
		
		for(int i=0;i<k;i++) {
			String temp[] = br.readLine().split(" ");
			
			if(temp[0].equals("push"))
				queue.offer(Integer.parseInt(temp[1]));
			
			
			else if(temp[0].equals("size"))
				bw.append(queue.size()+"\n");
			
			else if(temp[0].equals("empty")) {
				if(queue.isEmpty())
					bw.append(1+"\n");
				else
					bw.append("0\n");
			}
			
			else if(temp[0].equals("pop")) {
				if(queue.isEmpty())
					bw.append(-1+"\n");
				else
					bw.append(queue.pop()+"\n");
			}
			else if(temp[0].equals("front")) {
				if(queue.isEmpty())
					bw.append(-1+"\n");
				else
					bw.append(queue.peekFirst()+"\n");
			}
			else if(temp[0].equals("back")) {
				if(queue.isEmpty())
					bw.append(-1+"\n");
				else
					bw.append(queue.peekLast()+"\n");
			}
		}
		
		bw.flush();
		
	}
}
