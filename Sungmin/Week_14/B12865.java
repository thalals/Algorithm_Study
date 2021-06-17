import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12865 {
	static class Jewel{
		int value;
		int weight;
		Jewel(int value, int weight){
			this.value=value;
			this.weight=weight;
		}
	}//[n][k]//k가 감당 가능 무게, n이 보석 인덱스
	static void dp(Jewel[] jewels,int n,int k,int[][] dp) {
		for(int i=1;i<=n;i++) {
			for(int i1=1;i1<=k;i1++) {
				if(jewels[i].weight>i1)
					dp[i][i1]=dp[i-1][i1];
				else {
					dp[i][i1]=Math.max(dp[i-1][i1-jewels[i].weight]+jewels[i].value, dp[i-1][i1]);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] s=input.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int k=Integer.parseInt(s[1]);
		Jewel[] jewels=new Jewel[n+1];
		int[][] dp=new int[n+1][k+1];
		for(int i=1;i<=n;i++) {
			s=input.readLine().split(" ");
			int weight=Integer.parseInt(s[0]);
			int value=Integer.parseInt(s[1]);
			jewels[i]=new Jewel(value, weight);
		}
		dp(jewels, n, k, dp);
		//입력 완료
		System.out.print(dp[n][k]);
		input.close();
	}
}