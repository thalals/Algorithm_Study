/* boj 1874 스택 수열
 * 다음 수열로 오는 수가 stack의 peek보다 작은 수 이면 안됨
 */
package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class boj1874_스책수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder bw = new StringBuilder(); 
		
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q_list = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=1;i<=n;i++)
			q_list.offer(i);
		
		for(int i=0;i<n;i++) {
			int value = Integer.parseInt(br.readLine());
			
			while(true) {
				if(stack.isEmpty()) {
					stack.push(q_list.poll());
					bw.append("+\n");
				}
				else {
					//안되는 경우
					if(stack.peek()>value) {
						System.out.println("NO");
						return;
					}
					
					//진행하는 경우
					if(stack.peek()==value) {
						stack.pop();
						bw.append("-\n");
						break;
					}
					else {
						if(q_list.isEmpty()) {
							System.out.println("NO");
							return;
						}
						stack.push(q_list.poll());
						bw.append("+\n");
					}
				}
			}
		}
		System.out.println(bw.toString());
	}

}
