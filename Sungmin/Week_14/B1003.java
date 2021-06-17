import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1003 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(input.readLine());
		int[][] dp=new int[2][41];
		//[0][i]는 0의 개수, [1][i]는 1의 개수
		for(int i=0;i<=40;i++) {
			if(i==0) {
				dp[0][i]=1;
				dp[1][i]=0;
			}
			else if(i==1) {
				dp[0][i]=0;
				dp[1][i]=1;
			}
			else {
				dp[0][i]=dp[0][i-1]+dp[0][i-2];
				dp[1][i]=dp[1][i-1]+dp[1][i-2];
			}
		}
		for(int i=0;i<n;i++) {
			int k=Integer.parseInt(input.readLine());
			sb.append(dp[0][k]+" "+dp[1][k]+"\n");
		}
		System.out.print(sb);
		input.close();
	}
}