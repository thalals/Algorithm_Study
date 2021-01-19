package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위표기식2_1935 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split("");
		int input_result[] = new int[input.length];

		for (int i = 0; i < input.length; i++) {
			input_result[i] = (int) input[i].charAt(0); // 아스키 코드로 변환
		}

		double number[] = new double[n];
		for (int i = 0; i < n; i++) {
			double s = Double.parseDouble(br.readLine());
			number[i] = s;
		}

		double result = 0;

		Stack<Double> st = new Stack<Double>();

		for (int i = 0; i < input_result.length; i++) {
			if (input_result[i] >= 65 && input_result[i] <= 90) {
				st.push(number[input_result[i] - 65]);
			} else {
				double num1 = st.pop();
				double num2 = st.pop();
				double result_tmp = 0;

				switch (input_result[i]) {

				case 42:
					result_tmp = num2 * num1;
					break;

				case 43:
					result_tmp = num2 + num1;
					break;

				case 47:
					result_tmp = num2 / num1;
					break;

				case 45:
					result_tmp = num2 - num1;
					break;
				}

				st.push(result_tmp);

			}
		}

		System.out.printf("%.2f", st.pop());
	}

}
