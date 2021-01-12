/* 스터디 1주차
 * 스택 백준 10828번
 * 실버 4
 */
package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class 스택_10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			String tmp[] = br.readLine().split(" ");
			
			switch (tmp[0]) {
			case "push":
				st.push(Integer.parseInt(tmp[1]));
//				result.add(Integer.parseInt(tmp[1]));
				break;

			case "top":
				if(st.isEmpty())
					result.add(-1);
				else
					result.add(st.peek());
				break;
				
			case "size":
				result.add(st.size());
				break;
				
			case "empty" :
				if(st.isEmpty())
					result.add(1);
				else
					result.add(0);
				break;
			
			case "pop" :
				if(st.isEmpty())
					result.add(-1);
				else
					result.add(st.pop());
			}
		}
		
		for(int a : result)
			System.out.println(a);
		
	}

}
