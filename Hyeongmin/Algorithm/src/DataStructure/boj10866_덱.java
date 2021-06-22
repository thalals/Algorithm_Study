package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class boj10866_µ¦ {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int k = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new LinkedList<Integer>();
		
		for(int i=0;i<k;i++) {
			String temp[] = br.readLine().split(" ");
			
			if(temp[0].equals("push_front"))
				dq.offerFirst(Integer.parseInt(temp[1]));
			
			else if(temp[0].equals("push_back"))
				dq.offer(Integer.parseInt(temp[1]));
			
			else if(temp[0].equals("size"))
				bw.append(dq.size()+"\n");
			
			else if(temp[0].equals("empty")) {
				if(dq.isEmpty())
					bw.append(1+"\n");
				else
					bw.append("0\n");
			}
			
			else if(temp[0].equals("pop_front")) {
				if(dq.isEmpty())
					bw.append(-1+"\n");
				else
					bw.append(dq.pop()+"\n");
			}
			else if(temp[0].equals("pop_back")) {
				if(dq.isEmpty())
					bw.append(-1+"\n");
				else
					bw.append(dq.pollLast()+"\n");
			}
			
			else if(temp[0].equals("front")) {
				if(dq.isEmpty())
					bw.append(-1+"\n");
				else
					bw.append(dq.peekFirst()+"\n");
			}
			else if(temp[0].equals("back")) {
				if(dq.isEmpty())
					bw.append(-1+"\n");
				else
					bw.append(dq.peekLast()+"\n");
			}
		}
		
		bw.flush();
		
	}

}
