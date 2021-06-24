import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class B1874 {
	public static void main(String[] args) {
		try {
			Stack<Integer> array = new Stack<Integer>();
			List<Integer> array1 = new ArrayList<Integer>();
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			int x=Integer.parseInt(input.readLine());
			for(int i=0;i<x;i++) array1.add(i+1);
			for(int i=0;i<x;i++) {
				int num = Integer.parseInt(input.readLine());
				if(array.size()==0 || array.peek()<num) {
					 do{
						sb.append("+\n");
						array.push(array1.get(0));
						array1.remove(0);
				} while(array.peek()!=num);
				}
				if(array.peek()==num) {
					sb.append("-\n");
					array.pop();
				}
				else {
					System.out.println("NO");
					System.exit(0);
				}
			}
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}