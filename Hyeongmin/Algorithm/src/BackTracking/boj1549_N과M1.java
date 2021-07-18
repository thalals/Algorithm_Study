package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Combination Á¶ÇÕ
public class boj1549_N°úM1 {
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[] = br.readLine().split(" ");

		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);

		visit = new boolean[n];

		Combination(n, m, new int[m], 0);
	}

	public static void Combination(int n, int m, int result[], int count) {
		if (count == m) {
			for (int a = 0; a < m - 1; a++)
				System.out.print(result[a] + " ");
			System.out.println(result[m - 1]);

			return;
		}

		for (int i = 0; i < n; i++) {
			if (visit[i] == false) {
				result[count] = i + 1;
				visit[i] = true;
				Combination(n, m, result, count + 1);
				visit[i] = false;
			}
		}
	}

}
