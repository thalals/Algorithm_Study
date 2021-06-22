/*
 * 결국 스택문제. 닫는 괄호가 나오는 순간 스택에 쌓여있는 원소의 개수를 합에 더해주면 된다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class B10799_2 {
	public static void main(String[] args) throws IOException{
		int result=0;
		Stack<Integer> array = new Stack<Integer>();
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String s = input.readLine();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				if(array.size()!=0) array.set(array.size()-1, 2);
				array.push(1);
			}
			else if(s.charAt(i)==')') {
				if(array.peek()==1) {
					array.pop();
					result+=array.size();
				}
				else{
					array.pop();
					result+=1;
				}
			}
		}
		System.out.print(result);
		input.close();
	}
}