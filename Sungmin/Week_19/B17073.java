import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B17073 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] s=input.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int[] node=new int[n+1];
		int water=Integer.parseInt(s[1]);
		int count=0;
		for(int i=0;i<n-1;i++) {
			s=input.readLine().split(" ");
			int x=Integer.parseInt(s[0]);
			int y=Integer.parseInt(s[1]);
			if(node[x]<2)node[x]++;
			if(node[y]<2)node[y]++;
		}
		for(int i=2;i<=n;i++) {
			if(node[i]==1)count++;
		}
		System.out.format("%.6f",(double)water/count);
		input.close();
	}
}