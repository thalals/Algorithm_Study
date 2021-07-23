package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj14712_넴모넴모 {

	static int[][] map;
	static int N, M;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[] = br.readLine().split(" ");

		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		
		map = new int[N+1][M+1]; // 1-index
		
		dfs((N*M) -1);	//15
		System.out.println(count);
	}

	/* 1. 각 칸 마다 조회
	 * 2. 각 칸 차례일 때 각 칸에 네모가 (있을 때, 없을때)
	 * 3. 현재 칸에 네모를 놓았는데 주변에 3개가 있을 때 그냥 패스 -> 못 두는 경우
	 * 4. 네모를 존재 여부 -> 모든 칸 조회 한 후 (count++)
	 */
	
	public static void dfs(int cnt) {
		if(cnt == -1  ) {
			count++;
			return;
		}
		
		int x = cnt / M;	//열로 나눈다.
		int y = cnt %M;
		
//		x 1 0
//		x x 0
//		0 0 0
		
		System.out.println(x + " "+y);
		
		if(!(map[x][y+1]==1 && map[x+1][y]==1 && map[x+1][y+1]==1) ) {
			//현재칸 선택 x
			//현재 칸 선택
			map[x][y] = 1;
			dfs(cnt-1);
			
			//현캐 칸 선택 x
			map[x][y] = 0;
			}
		dfs(cnt-1);
						
		
	}

}
