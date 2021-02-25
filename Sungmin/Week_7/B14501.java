import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B14501 {
	static int max=0;
	static int x;
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			x=Integer.parseInt(input.readLine());
			int[] days = new int[x+1];
			int[] pays = new int[x+1];
			int[] dp = new int[x+1];
			for(int i=1;i<=x;i++) {
				String[] s = input.readLine().split(" ");
				days[i]=Integer.parseInt(s[0]);
				pays[i]=Integer.parseInt(s[1]);
			}
			for(int i=1;i<=x;i++) {
				if(i+days[i]<=x+1) {
					dp[i+days[i]]=Math.max(dp[i+days[i]], dp[i]+pays[i]);
					max=Math.max(max, dp[i+days[i]]);
					
					dp[i+1]=Math.max(dp[i+1],days[i]);
					max=Math.max(max, dp[i+1]);
				}
			}
			sb.append(max);
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}