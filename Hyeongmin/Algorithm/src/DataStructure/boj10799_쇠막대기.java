/* 레이저로 자르면 스택 사이즈 추가
 * 레이저 아니고 막내기 끝이면 +1
 * 
 */
package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj10799_쇠막대기 {
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line[] = br.readLine().split("");
		Stack<String> stack = new Stack<String>();
		
		int result = 0;
		String before = null;
		
		for(String a : line) {
			if(a.equals("(")) {
				stack.push(a);
				before = a;
			}
			else {
				//레이저
				if(before.equals("(")) {
					stack.pop();
					result+=stack.size();
					before = a;
				}
				else {
					stack.pop();
					result+=1;
					before = a;

				}
			}
		}
		
		System.out.println(result);
		
	}	
}
