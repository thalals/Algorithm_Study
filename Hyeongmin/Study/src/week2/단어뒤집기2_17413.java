/*
 * ½Ç¹ö3
 */
package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class ´Ü¾îµÚÁý±â2_17413 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder bw = new StringBuilder();
		
		String tmp[] = br.readLine().split(" ");
		
		boolean bracket_flag = false;

		for(int i=0;i<tmp.length;i++) {
			Stack<String> st = new Stack<String>();
			
			String word[] = tmp[i].split("");
			for(int j=0;j<word.length;j++) {
				if(bracket_flag) {			//°ýÈ£¾È¿¡ ´Ü¾î
					if(word[j].equals(">")) {	//°ýÈ£ ´ÝÀ»¶§
						bracket_flag = false;
						bw.append(word[j]);
						continue;
					}
					bw.append(word[j]);
					continue;
				}
				if(word[j].equals("<")) {	//°ýÈ£ ¸¸³µÀ» ¶§
					if(!st.isEmpty()) {
						while(!st.isEmpty())
							bw.append(st.pop());
					}
					
					bracket_flag = true;
					bw.append(word[j]);
				}
//				else if(word[j].equals(">")) {	//°ýÈ£ ´ÝÀ»¶§
//					bracket_flag = false;
//					bw.append(word[j]);
//				}
				
				
				else {
					st.push(word[j]);
				}
			}
			if(!st.isEmpty())
				while(!st.isEmpty())
					bw.append(st.pop());
			bw.append(" ");
		}
		
		System.out.println(bw);
		br.close();
	}
}
