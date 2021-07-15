package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj15661_링크와스타트 {

	static int S[][];
	static boolean visit[];
	static int sum = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		S = new int[n][n];
		visit = new boolean[n];
		
		for(int i=0;i<n;i++) {
			String temp[] = br.readLine().split(" ");
			
			for(int j=0;j<temp.length;j++)
				S[i][j] = Integer.parseInt(temp[j]);
		}
		// Combination 1~(n-1)
		// 능력치 합 -> 차이

		int number = (n % 2 == 0 ? n / 2 : (n / 2) + 1);

		for (int i = 1; i <= number; i++) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			Combination(n, i, result);
		}

		System.out.println(sum);
	}

	// type : (n, 뽑을 개수, 결과)
	public static void Combination(int n, int k, ArrayList<Integer> result) {
		// return
		if (result.size() == k) {
			int startTeam = TeamPower(result);

			ArrayList<Integer> other = new ArrayList<Integer>();
			for (int j = 1; j <= n; j++) {
				if (!result.contains(j))
					other.add(j);
			}

			int linkTeam = TeamPower(other);

			if (sum > Math.abs(linkTeam - startTeam))
				sum = Math.abs(linkTeam - startTeam);

			return;
		}

		for (int i = 1; i <= n; i++) {
			if (visit[i - 1] == false) {
				result.add(i);
				visit[i - 1] = true;
				Combination(n, k, result);
				
				visit[i - 1] = false;
				
				result.remove(result.size()-1);
			}
			
		}
	}

	// 뽑은 조합의 순열
	public static int TeamPower(ArrayList<Integer> result) {
		int TeamSocre = 0;

		for (int i = 0; i < result.size(); i++) {
			int value = result.get(i); // 중복이 없으니까 인덱스 대신 value로

			for (int a : result) {
				if (a == value)
					continue;
				else {
					TeamSocre += S[value-1][a-1];
				}
			}
		}

		return TeamSocre;
	}
}
