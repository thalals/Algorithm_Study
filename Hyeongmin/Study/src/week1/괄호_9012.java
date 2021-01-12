/* °ýÈ£ 9012
 * ½Ç¹ö 4, ½ºÅÃ
 */
package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class °ýÈ£_9012 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		for(int i=0;i<n;i++) {
			String tmp[] = br.readLine().split("");
			Stack<String> st = new Stack<String>();

			boolean check = false;

			for(int j=0;j<tmp.length;j++) {
				
				if(tmp[j].contains("("))
					st.push("(");
				else {
					if(st.isEmpty()) {
						System.out.println("NO");
						check = true;
						break;
					}
					st.pop();
				}
			}
			if(check)
				continue;
			if(st.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
		br.close();
	}

}
