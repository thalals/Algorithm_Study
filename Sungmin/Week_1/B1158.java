import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class B1158 {
	public static void main(String[] args) {
		try {
			Queue<Integer> array = new LinkedList<>();
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			String[] s = input.readLine().split(" ");
			int x=Integer.valueOf(s[0]);
			int y=Integer.valueOf(s[1]);
			int count=0;
			for(int i=1;i<=x;i++) array.add(i);
			sb.append("<");
			while(true) {
				count++;
				if(count%y==0) {
					sb.append(String.valueOf(array.poll()));
					if(array.size()==0) break;
					else sb.append(", ");
				}
				else array.add(array.poll());
			}
			sb.append(">");
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}