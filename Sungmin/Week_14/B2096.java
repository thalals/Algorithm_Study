import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2096 {
	static void dpmax(int[][] dp, String[] table) {
		for(int i=0;i<3;i++) {
			if(i==0)
				dp[1][i]=Math.max(dp[0][0], dp[0][1])+Integer.parseInt(table[0]);
			else if(i==1)
				dp[1][i]=Math.max(Math.max(dp[0][0], dp[0][1]), dp[0][2])+Integer.parseInt(table[1]);
			else
				dp[1][i]=Math.max(dp[0][1], dp[0][2])+Integer.parseInt(table[2]);
		}
		for(int i=0;i<3;i++)
			dp[0][i]=dp[1][i];
	}
	
	static void dpmin(int[][] dp, String[] table) {
		for(int i=0;i<3;i++) {
			if(i==0)
				dp[1][i]=Math.min(dp[0][0], dp[0][1])+Integer.parseInt(table[0]);
			else if(i==1)
				dp[1][i]=Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2])+Integer.parseInt(table[1]);
			else
				dp[1][i]=Math.min(dp[0][1], dp[0][2])+Integer.parseInt(table[2]);
		}
		for(int i=0;i<3;i++)
			dp[0][i]=dp[1][i];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(input.readLine());
		int[][] dpmax=new int[2][3];
		int[][] dpmin=new int[2][3];
		//입력 완료
		for(int i=0;i<n;i++) {
			String[] s=input.readLine().split(" ");
			if(i==0) {
				for(int i1=0;i1<3;i1++) {
					dpmax[0][i1]=Integer.parseInt(s[i1]);
					dpmin[0][i1]=Integer.parseInt(s[i1]);
				}
			}
			else {
				dpmax(dpmax, s);
				dpmin(dpmin, s);
			}
		}
		int max=Math.max(Math.max(dpmax[0][0], dpmax[0][1]), dpmax[0][2]);
		int min=Math.min(Math.min(dpmin[0][0], dpmin[0][1]), dpmin[0][2]);
		System.out.print(max+" "+min);
		input.close();
	}
}