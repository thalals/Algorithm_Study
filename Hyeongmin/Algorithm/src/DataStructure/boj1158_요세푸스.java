/* boj 1158 요세푸스
 * <n,k> 순열 구하기
 * Deque 이용
 * 
 */
package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class boj1158_요세푸스 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		
		String[] temp = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		
		
		Deque<Integer> list = new ArrayDeque<Integer>();
		
		for(int i=1;i<=n;i++)
			list.add(i);
		
		while(!list.isEmpty()) {
			if(list.size()==1) {
				sb.append(list.poll()+">");
				break;
			}
			for(int i=1;i<k;i++) {
				int temp1 = list.poll();
				list.add(temp1);
			}
			sb.append(list.poll()+", ");
		}
		
		
		
		System.out.print(sb.toString());
	}

}
