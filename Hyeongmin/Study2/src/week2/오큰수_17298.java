package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 오큰수_17298 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		String line[] = br.readLine().split(" ");

		int result[] = new int[n];
		for(int i=0;i<n;i++)
			result[i] = -1;
		
		Stack<int[]> st = new Stack<int[]>();
		
		for (int i = 0; i < n; i++) {
			int number[] = new int [2];
			number[0] = Integer.parseInt(line[i]);
			number[1] = i;	//입력순서

			if(st.isEmpty())
				st.push(number);
			else {
				while(!st.isEmpty() && st.peek()[0] < number[0]) {
					result[st.peek()[1]] = number[0];
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
