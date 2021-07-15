package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class boi21315_Ä«µå¼¯±â {
	static boolean visit[];
	static ArrayList<int[]> Combi_list = new ArrayList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String temp[] = br.readLine().split(" ");

		Deque<Integer> card = new ArrayDeque<Integer>();

		for (String a : temp)
			card.add(Integer.parseInt(a));

		int k = 0;

		while (true) {
			k++;
			if (Math.pow(2,k) > n) {
				k = k - 1;
				break;
			} else if (Math.pow(2, k) == n)
				break;
		}

		visit = new boolean[k];

		Combination(0, k, new int[k]);

		for (int list[] : Combi_list) {

		}
	}

	public static void shake(int k, int[] card) {
		int i = 1;
		while (i <= k + 1) {
			int move = (int)Math.pow(2,k-i+1 );
			
			for (int j = 0; j < Math.pow(2,k-i+1 ); j++) {
				
			}
		}

	}

	public static void Combination(int index, int k, int result[]) {

		if (index == k) {
			int temp[] = new int[k];
			int q = 0;
			for (int a : result)
				temp[q++] = a;
			Combi_list.add(temp);
			return;
		}
		for (int i = 1; i <= k; i++) {
			if (visit[i - 1] == false) {
				result[index] = i;
				visit[i - 1] = true;
				Combination(index + 1, k, result);

				visit[i - 1] = false;
			}

		}

	}

}
