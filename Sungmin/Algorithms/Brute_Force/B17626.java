/*
 * combination의 특징을 한 번 되새겨보는 시간을 가짐. 3차원까지가려다 말았다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B17626 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(input.readLine());
		int[] dp=new int[n+1];
		for(int i=1;i<=n;i++) {
			if(Math.sqrt(i)%1==0)
				dp[i]=1;
			else
				dp[i]=dp(dp,i);
		}
		System.out.print(dp[n]);
		input.close();
	}
	static int dp(int[] dp, int num) {
		int result=dp[num-1];
		for(int i=2;i*i<num;i++) {
			if(result>dp[num-i*i])
				result=dp[num-i*i];
		}
		return result+1;
	}
}