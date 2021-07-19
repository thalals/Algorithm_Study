package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj15653_N°úM5 {

	static boolean visit[];
	static int list[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[] = br.readLine().split(" ");

		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		list = new int[n];
		
		temp = br.readLine().split(" ");
		
		for(int i=0;i<n;i++)
			list[i] = Integer.parseInt(temp[i]);
		
		Arrays.sort(list);
		visit = new boolean[n];

		Combination(n, m, new int[m], 0);
		System.out.println(sb.toString());
	}

	public static void Combination(int n, int m, int result[], int count) {
		if (count == m) {
			for (int a = 0; a < m - 1; a++)
				sb.append(result[a] + " ");
			sb.append(result[m - 1]+"\n");

			return;
		}

		for (int i = 0; i < n; i++) {
			if (visit[i] == false) {
				result[count] = list[i];
				visit[i] = true;
				Combination(n, m, result, count + 1);
				visit[i] = false;
			}
		}
	}

}
