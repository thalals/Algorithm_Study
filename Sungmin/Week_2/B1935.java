import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class B1935 {
	public static void main(String[] args) {
		try {
			Stack<Double> result = new Stack<Double>();
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			int x=Integer.parseInt(input.readLine());
			String s = input.readLine();
			double temp;
			int[] nums = new int[x];
			for(int i=0;i<x;i++) nums[i]=Integer.parseInt(input.readLine()); 
			for(int i=0;i<s.length();i++) {
				//if(s.charAt(i)=='*'||s.charAt(i)=='/'||s.charAt(i)=='+'||s.charAt(i)=='/')
				if(s.charAt(i)=='*') result.push(result.pop()*result.pop());
				else if(s.charAt(i)=='+') result.push(result.pop()+result.pop());
				else if(s.charAt(i)=='/') {
					temp=result.pop();
					result.push(result.pop()/temp);
				}
				else if(s.charAt(i)=='-') {
					temp=result.pop();
					result.push(result.pop()-temp);
				}
				else result.push((double)nums[s.charAt(i)-65]);
			}
			System.out.print(String.format("%.2f", result.pop()));
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}