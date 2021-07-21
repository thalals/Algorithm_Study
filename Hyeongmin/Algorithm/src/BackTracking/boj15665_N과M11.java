package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class boj15665_N°úM11 {
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

		for (int i = 0; i < n; i++)
			list[i] = Integer.parseInt(temp[i]);

		Arrays.sort(list);
		visit = new boolean[n];

		Permutation(n, m, new int[m], 0, 0);

		System.out.println(sb.toString());
	}

	public static void Permutation(int n, int m, int result[], int count, int start) {
		HashSet<Integer> hashset = new HashSet<Integer>();

		if (count == m) {
			for (int a : result)
				sb.append(a + " ");
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {

			if (hashset.isEmpty()) {

				result[count] = list[i];
				hashset.add(list[i]);
				Permutation(n, m, result, count + 1, i);
			}

			else {
				if (!hashset.contains(list[i])) {
					result[count] = list[i];
					hashset.add(list[i]);
					Permutation(n, m, result, count + 1, i);
				}
			}

		}
	}
}
