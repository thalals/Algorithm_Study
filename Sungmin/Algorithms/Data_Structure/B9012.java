/*
 * 학과시절 배웠던 스택을 이용한 괄호 판별기
 * 괄호를 짝에 맞추어 push/pop을 거쳐 참/거짓을 판별한다.
 * (닫는 소괄호가 나오면 여는 소괄호와 같이 pop, 아니라면 NO)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class B9012 {
	public static void main(String[] args) throws IOException{
		Stack<Character> array = new Stack<Character>();
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x=Integer.parseInt(input.readLine());
		for(int i=0;i<x;i++) {
			array.clear();
			String s = input.readLine();
			for(int i1=0;i1<s.length();i1++) {
				if(s.charAt(i1)=='(')//push
					array.push(s.charAt(i1));
				else if(s.charAt(i1)==')') {//pop
					if(array.size()==0) {//짝이 안 맞는 경우
						sb.append("NO\n");
						break;
					}
					else array.pop();
				}
				if(i1==s.length()-1) {
					if(array.size()==0)sb.append("YES\n");
					else sb.append("NO\n");
				}
			}
		}
		System.out.print(sb);
		input.close();
	}
}