package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj1935_후위표기식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		String line[] = br.readLine().split("");

		double value[] = new double[n + 1];

		for (int i = 0; i < n; i++)
			value[i ] = Integer.parseInt(br.readLine());

		// 후위 연산
		Stack<Double> stack = new Stack<Double>();
		String compare = "QWERTYUIOPASDFGHJKLZXCVBNM";

		for (String a : line) {			
			if (compare.contains(a)) {
				stack.push(value[a.charAt(0)-65]);
			} 
			else {
				switch (a) {
					case "+": {
						double a1 = stack.pop();
						double b1 = stack.pop();
						stack.push(a1 + b1);
						break;
					}
					case "-": {
						double a1 = stack.pop();
						double b1 = stack.pop();
						stack.push(b1 - a1);	
						break;
					}
					case "/": {
						double a1 = stack.pop();
						double b1 = stack.pop();
						stack.push(b1 / a1);
						break;

					}
					case "*": {
						double a1 = stack.pop();
						double b1 = stack.pop();
						stack.push(a1 * b1);
						break;

					}
				}
			}
		}
		System.out.printf("%.2f",stack.pop());
	}

}
