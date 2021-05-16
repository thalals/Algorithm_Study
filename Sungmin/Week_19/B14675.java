import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B14675 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(input.readLine());
		int[] findroot=new int[n+1];
		for(int i=0;i<n-1;i++) {
			String[] s =input.readLine().split(" ");
			findroot[Integer.parseInt(s[0])]++;
			findroot[Integer.parseInt(s[1])]++;
		}
		n=Integer.parseInt(input.readLine());
		for(int i=0;i<n;i++) {
			String[] s=input.readLine().split(" ");
			if(Integer.parseInt(s[0])==1) {
				if(findroot[Integer.parseInt(s[1])]>=2)
					sb.append("yes\n");
				else sb.append("no\n");
			}
			else sb.append("yes\n");
		}
		System.out.print(sb);
		input.close();
	}
}