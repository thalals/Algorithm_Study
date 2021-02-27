package sw;

import java.io.*;
import java.util.*;

class stage {
	String skill;
	int index;
	boolean first = true;

	stage(String skill, int index, boolean first) {
		this.skill = skill;
		this.index = index;
		this.first = first;
	}

	stage() {
	};
}

public class 일번 {
	static ArrayList<stage> map[];
	static boolean visit[];
	static String result[];
	static int count = 0;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[] = br.readLine().split(" ");

		map = new ArrayList[temp.length];
		visit = new boolean[temp.length + 1];
		result = new String[temp.length];

		for (int i = 0; i < temp.length; i++) {
			map[i] = new ArrayList<stage>();
			stage t = new stage(temp[i], i, true);

			map[i].add(t); // map에는 (skill,index)
		}

		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			String next_skill[] = br.readLine().split(" ");

			int start_index = -1;
			int next_index = -1;

			for (int j = 0; j < temp.length; j++) {
				if (temp[j].contains(next_skill[0]))
					start_index = j;
				if (temp[j].contains(next_skill[1]))
					next_index = j;
			}

			stage add_stage = new stage(temp[next_index], next_index, false);
			map[next_index].get(0).first = false; // 앞에 선행 스킬이 있다.

			map[start_index].add(add_stage);
		}

		// 선행스킬이 없는 단독스킬 dfs
		for (int i = 0; i < temp.length; i++) {
			if (map[i].get(0).first) {
				Arrays.fill(result, null);
				count = 0;

				dfs(i);
			}
		}
	}

	static void dfs(int start) {
		if (visit[start]) {
			return;
		}
		visit[start] = true;
		result[count++] = map[start].get(0).skill;

		if (map[start].size() == 0) {
			for (int i = 0; i < result.length; i++) {
				if (result[i] != null) {
					System.out.print(result[i]);
					if (i + 1 < result.length || result[i + 1] != null)
						System.out.print(" ");
				}
			}
			System.out.println();
			return;
		} else {
			boolean check = true;
			for (int i = 0; i < map[start].size(); i++) {
				if (!visit[map[start].get(i).index]) {
					check = false; // 아직 방문하지 않은곳
				}
			}
			if (check) {
				for (int i = 0; i < result.length; i++) {
					if (result[i] != null) {
						System.out.print(result[i]);
						if (i + 1 < result.length) {
							if (result[i + 1] != null)
								System.out.print(" ");
						}
					}
				}
				System.out.println();
				return;
			}
		}
		
//			dfs
		for (int i = 1; i < map[start].size(); i++) {
			if (!visit[map[start].get(i).index]) {
				dfs(map[start].get(i).index);
			}
			visit[map[start].get(i).index] = false;
			result[count]=null;
			count--;
		}
	}

}
