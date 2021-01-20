import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class B1918 {
	public static void main(String[] args) {
		try {
			Stack<Character> result = new Stack<Character>();
			Stack<Character> array2 = new Stack<Character>();
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder output = new StringBuilder();
			String s = input.readLine();
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='*'||s.charAt(i)=='/') {
					while(!array2.empty()&&(array2.peek()=='*'||array2.peek()=='/'))
						result.push(array2.pop());
					array2.push(s.charAt(i));
				}
				else if(s.charAt(i)=='+'||s.charAt(i)=='-') {
					while(!array2.empty()&&(array2.peek()=='*'||array2.peek()=='/'||array2.peek()=='+'||array2.peek()=='-'))
						result.push(array2.pop());
					array2.push(s.charAt(i));
				}
				else if(s.charAt(i)==')') {
					while(array2.peek()!='(') result.push(array2.pop());
					array2.pop();
				}
				else if(s.charAt(i)=='(') array2.push('(');
				else result.push(s.charAt(i));
			}
			while(!array2.empty()) result.push(array2.pop());
			for(int i=0;i<result.size();i++) output.append(result.get(i));
			//while(!result.empty()) output.append(result.pop());
			System.out.print(output);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}