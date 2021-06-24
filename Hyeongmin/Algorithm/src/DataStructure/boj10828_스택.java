package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj10828_Ω∫≈√ {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int k = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<k;i++) {
			String temp[] = br.readLine().split(" ");
			
			if(temp[0].equals("push"))
				stack.push(Integer.parseInt(temp[1]));
			
			else if(temp[0].equals("top")) {
				if(stack.isEmpty())
					bw.append("-1\n");
				else
					bw.append(stack.peek()+"\n");
			}
			
			else if(temp[0].equals("size"))
				bw.append(stack.size()+"\n");
			
			else if(temp[0].equals("empty")) {
				if(stack.isEmpty())
					bw.append(1+"\n");
				else
					bw.append("0\n");
			}
			
			else if(temp[0].equals("pop")) {
				if(stack.isEmpty())
					bw.append(-1+"\n");
				else
					bw.append(stack.pop()+"\n");
			}	
		}
		
		bw.flush();
		
	}

}
