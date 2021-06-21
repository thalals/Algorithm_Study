package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Stack;

public class 오등큰수_17299 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
				
		String t[] = br.readLine().split(" ");
		
		int f[] = new int[1000001];
		
		for(String a : t)
			f[Integer.parseInt(a)]+=1;
		
		int result[] = new int[n];
		for(int i=0;i<n;i++)
			result[i] = -1;
		
		Stack<int[]> st = new Stack<int[]>();
		for(int i=0;i<n;i++) {
			int number[] = new int[3];
			number[0] = Integer.parseInt(t[i]);
			number[1] = f[number[0]];
			number[2] = i;
			
			if(st.isEmpty())
				st.push(number);
			else {
				while(!st.isEmpty() && st.peek()[1] < number[1]) {
					result[st.peek()[2]] = number[0];
					st.pop();
					continue;
				}
				st.push(number);
			}			
		}
		for(int a : result)
			bw.append(a+" ");
		bw.close();
		br.close();
	}

}
