import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class B10799_2 {
	public static void main(String[] args) {
		try {
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
			//while(array.size()!=0) result+=array.pop();
			System.out.print(result);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}