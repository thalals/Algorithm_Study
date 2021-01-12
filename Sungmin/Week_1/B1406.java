import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class B1406 {
	public static void main(String[] args) {
		try {
			Stack<Character> array = new Stack<Character>();
			Stack<Character> array1 = new Stack<Character>();
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			String s = input.readLine();
			for(int i=0;i<s.length();i++) array.push(s.charAt(i));
			int x=Integer.parseInt(input.readLine());
			for(int i=0;i<x;i++) {
				String[] command = input.readLine().split(" ");
				if(command[0].equals("L")&&array.size()!=0) array1.push(array.pop());
				else if(command[0].equals("D")&&array1.size()!=0) array.push(array1.pop());
				else if(command[0].equals("B")&&array.size()!=0) array.pop();
				else if(command[0].equals("P")) array.push(command[1].charAt(0));
			}
			char[] result=new char[array.size()+array1.size()];
			for(int i=array.size()-1;i>=0;i--) result[i]=array.pop();
			for(int i=result.length-array1.size();i<result.length;i++)result[i]=array1.pop();
			for(int i=0;i<result.length;i++) sb.append(result[i]);
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}