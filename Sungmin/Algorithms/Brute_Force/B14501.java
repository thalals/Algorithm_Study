/*
 * 퇴사마렵다. 각 일마다 일을 하는 경우와 안 하는 경우의 각 최대값을 갱신시켜주면 됨
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class B14501 {
	static int max=0;
	static int x;
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		x=Integer.parseInt(input.readLine());
		int[] days = new int[x+1];
		int[] pays = new int[x+1];
		int[] dp = new int[x+2];
		for(int i=1;i<=x;i++) {
			StringTokenizer stk=new StringTokenizer(input.readLine());
			days[i]=Integer.parseInt(stk.nextToken());
			pays[i]=Integer.parseInt(stk.nextToken());
		}
		for(int i=1;i<=x;i++) {//그 일을 하는 경우와 안 하는 경우로 나뉨
			if(i+days[i]>x+1) {//근무 일수 초과시 할 수 가 없음
				dp[i+1]=Math.max(dp[i+1], dp[i]);
			}
			else {
				dp[i+days[i]]=Math.max(dp[i+days[i]], pays[i]+dp[i]);//일을 하는 경우
				dp[i+1]=Math.max(dp[i+1], dp[i]);//일을 안 하는 경우
			}
		}
		System.out.print(dp[x+1]);
		input.close();
	}
}