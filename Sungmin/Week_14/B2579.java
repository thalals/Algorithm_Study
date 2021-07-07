import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(input.readLine());
		int[] table=new int[n];
		int[] dp=new int[n];
		for(int i=0;i<n;i++) {
			table[i]=Integer.parseInt(input.readLine());
			if(i==0) dp[0]=table[0];
			else if(i==1) dp[1]=Math.max(table[1], table[0]+table[1]);
			else if(i==2) dp[2]=Math.max(table[0]+table[2], table[1]+table[2]);
			else dp[i]=Math.max(dp[i-3]+table[i-1]+table[i], dp[i-2]+table[i]);
		}
		System.out.print(dp[n-1]);
		input.close();
	}
}