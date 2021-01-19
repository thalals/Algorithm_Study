import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class B17413 {
	public static void main(String[] args) {
		try {
			Stack<Character> array = new Stack<Character>();
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			String s = input.readLine();
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='<') {
					while(array.size()!=0) sb.append(array.pop());
					while(true) {
						if(s.charAt(i)=='>') {
							sb.append(">");
							break;
						}
						sb.append(s.charAt(i));
						i++;
					}
				}
				else if(s.charAt(i)==' ') {
					while(array.size()!=0) sb.append(array.pop());
					sb.append(" ");
				}
				else array.push(s.charAt(i));
			}
			while(array.size()!=0) sb.append(array.pop());
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}