package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj2504_괄호의값 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line[] = br.readLine().split("");

		Stack<String> stack = new Stack<String>();
		int result = 0;
		int temp = 0;

		result = real_life(stack, line, 0); // stack,line,index
		
		System.out.println(result);
	}

	static int result_value(Stack<String> stack, String line[], int index) {
		int temp = 0;
		int val_index = index;
		
		temp = real_life(stack, line, val_index);
		return temp;
	}
	
	static int real_life(Stack<String> stack, String line[], int index) {
		int temp = 0;
		int val_index = index;
	
		String key = line[index-1];
		if(key.equals("("))
			key = ")";
		else
			key="]";
		
		// key 만날때 까지
		for (int i = index;i<line.length;i++) {
			val_index++;
			
			if (line[i].equals("(") || line[i].equals("[")) {
				stack.push(line[i]);
				// 재귀함수 있으면 좋을거 같음
				if(line[i].equals("("))
					temp = 2*real_life(stack, line, val_index);
				else
					temp = 3*real_life(stack, line, val_index);
				if(temp==0)
					return 0;
			}
			//pop 하는 경우
			else {
				// 올바르지 경우 1
				if (stack.isEmpty()) {
					return 0;
				}
				//탈출
				else if(line[i].equals(key)) {
					if (line[i].equals(")")) {
						// 올바르지 경우 2
						if (stack.peek().equals("[")) {
							return 0;
						}
						temp+=2;
						return temp;
					}

					else if (line[i].equals("]")) {
						// 올바르지 경우 3
						if (stack.peek().equals("(")) {
							return 0;
						}
						temp+=3;
						return temp;

					}
				}
				else {
					if (line[i].equals(")")) {
						// 올바르지 경우 2
						if (stack.peek().equals("[")) {
							return 0;
						}
						temp+=2;
					}

					else if (line[i].equals("]")) {
						// 올바르지 경우 3
						if (stack.peek().equals("(")) {
							return 0;
						}
						temp+=3;
					}
				}
					
			}
		}
		
		return temp;
	}
}
