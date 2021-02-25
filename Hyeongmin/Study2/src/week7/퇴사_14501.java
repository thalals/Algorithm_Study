package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_14501 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int t[] = new int[n + 2];
		int p[] = new int[n + 2];
		int dp[] = new int[n + 2];	//i일 까지 최대 받을 수 잇는 금액

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());	//i날
			p[i] = Integer.parseInt(st.nextToken());	//금액
		}
		
		int max = 0;
		
		for(int i=1;i<n+2;i++) {
			if(t[i] <= n+1)
				dp[i] = Math.max(dp[i], max);
				
				//상담 후일 그날 받을 수 있는 금액
				if(i+t[i]<=n+1)
					dp[i+t[i]] = Math.max(dp[i+t[i]], p[i]+dp[i]); //전에 저장된 값, 새로 갱신되는값
				
				max = Math.max(dp[i], max);	//i일 까지 받을 수 있는 최대금액
		}	
		
		System.out.println(max);
		
		br.close();
		
	}

}
