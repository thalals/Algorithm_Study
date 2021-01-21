package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 후위표기식_1918 {

	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line[] = br.readLine().split("");
		
		Stack<String[]> st = new Stack<String[]>();
		for(int i=0;i<line.length;i++) {
			String key[] = new String[2];
			key[0]= line[i];
			
			if(key[0].equals("+")||key[0].equals("-"))
				key[1] = "0";
			else if(key[0].equals("*")||key[0].equals("/"))
				key[1] = "1";
			else if(key[0].equals("("))
				key[1] = "-1";
			else if(key[0].equals(")"))
				key[1] = "-1";
			else
				key[1] = "3";
			
			//문자일때
			if(key[1].equals("3"))
				bw.append(key[0]+"");
			//스택에 아무것도 없을때
			else if(st.isEmpty())
				st.push(key);
			//들어오는게 우선순위가 높으며 스택에 넣음
			else {
				if(key[0].equals("("))
					st.push(key);
				else if(Integer.parseInt(st.peek()[1]) < Integer.parseInt(key[1]))
					st.push(key);
				else if(key[0].equals(")")) {
					while(!st.isEmpty()&&!st.peek()[0].equals("(")) {
						bw.append(st.pop()[0]);
					}
					st.pop();
				}
				
				else {
					while(!st.isEmpty()&&Integer.parseInt(st.peek()[1]) >= Integer.parseInt(key[1])) {
						if(st.peek()[1].equals("-1")) {
							st.pop();
						}
						else {
							bw.append(st.pop()[0]+"");
						}
					}
					st.push(key);
				}
			}
			
		}
		
		while(!st.isEmpty()) {
			if(st.peek()[1].equals("-1")) {
				st.pop();
			}
			else {
				bw.append(st.pop()[0]+"");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
