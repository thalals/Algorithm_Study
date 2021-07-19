package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj15652_N°úM4 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp[] = br.readLine().split(" ");

		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);

		int[] result = new int[m];

		Permutation(n, m, 0, result, 0);
		
		System.out.println(sb.toString());
	}

	public static void Permutation(int n, int m, int count, int result[], int start) {
		if (count == m) {
			for (int i = 0; i < m - 1; i++)
				 sb.append(result[i] + " ");
			sb.append(result[m - 1]+"\n");

			return;
		}

		for (int i = start; i < n; i++) {

			result[count] = i + 1;
			Permutation(n, m, count + 1, result, i);

		}

	}

}
