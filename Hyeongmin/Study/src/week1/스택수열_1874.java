/* 스택 수열 1874
 * 실버 3
 */
package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class 스택수열_1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
//		ArrayList<String> result = new ArrayList<String>();
		
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> list = new ArrayDeque<Integer>();

		for(int i=0;i<n;i++) {
			int a = Integer.parseInt(br.readLine());
			list.add(a);
		}
		
		Stack<Integer> st = new Stack<Integer>();
		
		int count = 1;
		
		boolean flag = true;
		
		while(!list.isEmpty()) {
			int tmp = list.peekFirst();
			
			if(st.isEmpty()) {
				st.push(count++);
//				result.add("+");
				sb.append("+"+"\n");
				continue;
			}
			
			if(st.peek()==tmp) {
				st.pop();
				list.poll();
//				result.add("-");

				sb.append("-"+"\n");
			}
			//같지 않은경우
			else {
				if(st.peek()>list.peekFirst()) {
					System.out.println("NO");
					flag = false;
					break;
				}
				
				else  {
					st.push(count++);
//					result.add("+");

					sb.append("+"+"\n");
				}
			}	
		}
		
		if(flag) {
			System.out.print(sb);
//			for(String s : result)
//				System.out.println(s);
		}
		br.close();
//		bw.close();
	}

}
