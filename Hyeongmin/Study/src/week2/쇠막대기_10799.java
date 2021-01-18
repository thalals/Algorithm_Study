package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

//½Ç¹ö3 ¼è¸·´ë±â
public class ¼è¸·´ë±â_10799 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<String> st = new Stack<String>();
		
		
		String back_word = null;
		
		int count = 0;
		
		String[] line = br.readLine().split("");
		
		for(int i=0;i<line.length;i++) {
			String key = line[i];
			
			switch (key) {
			case "(":
				st.push(key);
				back_word = key;
				
				break;

			case ")":
				if(back_word.equals("(")) {
					st.pop();
					count = count+ st.size();
					back_word=key;
				}
				else {
					st.pop();
					count =count+1;
					back_word=key;
				}
				break;
			}
		}
		System.out.println(count);
		
		br.close();
	}

}
