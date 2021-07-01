/* 문자열 비교로 하면 시간초과 n^2
 * 
 * HashSet 이용 : Hash 알고리즘은 검색속도가 매우 빠름
 */
package DataStructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.HashSet;

public class boj14425_문자열집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		String temp[] = br.readLine().split(" ");

		HashSet<String> list = new HashSet<String>();
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		while(n-->0)
			list.add(br.readLine());
		
		int count =0;
		while(m-->0) {
			String line = br.readLine();
			if(list.contains(line))
				count++;
		}
		
		System.out.println(count);
	}

}
