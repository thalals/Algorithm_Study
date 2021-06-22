/* boj9012 °ýÈ£
 * ½ºÅÃ ÀÌ¿ë
 * 
 */
package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj9012_°ýÈ£ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			Stack<String> stack = new Stack<String>();

			String temp[] = br.readLine().split("");

			boolean flag = false;

			for (int j = 0; j < temp.length; j++) {
				if (temp[j].equals("("))
					stack.push(temp[j]);
				else {
					if (stack.isEmpty()) {
						bw.append("NO\n");
						flag = true;
						break;
					}
					stack.pop();
				}
			}
			if (!flag) {
				if (stack.isEmpty())
					bw.append("YES\n");
				else
					bw.append("NO\n");
			}
		}
		
		bw.flush();
	}

}
