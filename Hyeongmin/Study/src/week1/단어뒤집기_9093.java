package week1;

import java.io.*;
import java.util.*;

public class 단어뒤집기_9093 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Stack<String> st = new Stack<String>();

		for(int i =0;i<n;i++) {
			String temp[] = br.readLine().split(" ");
			
			
			for(int j=0;j<temp.length;j++) {
				String[] t = temp[j].split("");
				
				for(int k =0;k<t.length;k++)
					st.push(t[k]);
				for(int k =0;k<t.length;k++)
					bw.append(st.pop());
				
				bw.append(" ");
			}
			bw.append("\n");
			
		}
		
		bw.flush();
	}

}
