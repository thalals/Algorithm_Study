package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class xy implements Comparable<xy>{
	int x;
	int y;

	xy(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(xy o) {
		if(this.y >o.y)
			return 1; //열 오름차순
		else if(this.y == o.y) {
			if(this.x< o.x) //행 내림차순
				return 1;
		}
			
		return -1;
	}
}

public class 미네랄_2933 {

	static int r, c;
	static String map[][];
	static boolean visit[][];

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String temp[] = br.readLine().split(" ");

		r = Integer.parseInt(temp[0]);
		c = Integer.parseInt(temp[1]);

		map = new String[r][c];
		visit = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			temp = br.readLine().split("");
			for (int j = 0; j < c; j++) {
				map[i][j] = temp[j];
			}
		}

		/*---------------intput-------*/

		int n = Integer.parseInt(br.readLine());

		temp = br.readLine().split(" "); // 던지는 높이

		// 왼쪽 부터 번갈아 가면서 던지기
		for (int i = 0; i < n; i++) {
			int shot = r-Integer.parseInt(temp[i]);

			String check = String.valueOf('x');

			boolean flag = false;
			// 왼쪽
			if (i % 2 == 0) {
				for (int j = 0; j < c; j++) {
					// 미네랄 ㅃ심
					if (map[shot][j].contains(check)) {
						map[shot][j] = String.valueOf('.');
						flag = true;
						break;
					}
				}
			}

			// 오른쪽
			else {
				for (int j = c - 1; j >= 0; j--) {
					// 미네랄 ㅃ심
					if (map[shot][j].contains(check)) {
						map[shot][j] = String.valueOf('.');
						flag = true;
						break;
					}
				}
			}

			/*--------던진 후 뿌신게 있으면 글리스터 확인--------*/
			if (flag) {
				GlisterXCheck();
				visit = new boolean[r][c];
			}

		}
		
		/*-------결과출력-----------*/
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(j==c-1)
					System.out.println(map[i][j]);
				else
					System.out.print(map[i][j]+" ");
			}
		}
	}

	// 바닥에 붙어 글리스터에서 떨어진 글리스터 판단
	static void GlisterXCheck() {
		
		//바닥에 붙어있는 글리스터 방문처리
		for (int i = 0; i < c; i++) 
			if (map[r - 1][i].contains(String.valueOf('x')) && !visit[r - 1][i]) 
				Glister(r - 1, i);
		
		ArrayList<xy> list = new ArrayList<xy>();
		
		//바닥에서 떨어진 애 체크
		for(int i=0;i<r;i++) {

			for(int j=0;j<c;j++) {
				//발견
				if(map[i][j].contains(String.valueOf('x')) && !visit[i][j]) {
					// list(x,y) : 한덩어리 리턴 
					aboveGlister(i,j,list);
					
					//열로 정렬(열의 가장 아래가 바닥)
					Collections.sort(list);
					
					//바닥으로 얼마나 내려갈지
					int down = getdown(list);
					
					//맵 갱신
					if(down!=0) {
						DrawDown(list, down);
						//하나 떨어트리면 break;
						return;
					}
					

				}
				
				
			}
		}
	}
	//실제 내려가는 함수
	static void DrawDown(ArrayList<xy> temp, int down) {
		for(xy e : temp) {
			int nextx = e.x+down;
			int nexty = e.y;
			
			map[e.x][e.y] = String.valueOf('.');
			map[nextx][nexty] = String.valueOf('x');	
			
			visit[e.x][e.y] = false;
			visit[nextx][nexty] = true;
		}
	}
	
	static int getdown(ArrayList<xy> temp) {
		//temp : 열(y)오름차 , 행(x) 내림차순 정렬
		
		int starty = temp.get(0).y;
		int down_min = Integer.MAX_VALUE;
		
		for(int i=0;i<temp.size();i++) {
			xy e = temp.get(i);
			if(i==0) {
				for(int j=e.x+1;j<r;j++) {
					//미네랄 위에
					if(map[j][e.y].contains(String.valueOf('x'))) {
						down_min = Math.min(down_min, (j-1)-e.x);
						break;
					}
					//바닥
					else if(j==r-1) {
						down_min = Math.min(down_min, j-e.x);
						break;
					}
				}
			}
			else {
				// 바닥면만 체크
				if(temp.get(i).y!=starty) {
					starty = temp.get(i).y;
					
					for(int j=e.x+1;j<r;j++) {
						//미네랄 위에
						if(map[j][e.y].contains(String.valueOf('x'))) {
							down_min = Math.min(down_min, (j-1)-e.x);
							break;
						}
						//바닥
						else if(j==r-1) {
							down_min = Math.min(down_min, j-e.x);
							break;
						}
					}
				}
			}
		}
		
		return down_min;
	}

	static void Glister(int dr, int dc) {
		ArrayDeque<xy> list = new ArrayDeque<xy>();
		
		if(!visit[dr][dc]) 
			visit[dr][dc] =true;
		
		
		for (int i = 0; i < 4; i++) {
			int nextx = dr + dx[i];
			int nexty = dc + dy[i];

			if (nextx < 0 || nexty < 0 || nextx > r - 1 || nexty > c - 1)
				continue;
			//아직 방문한 적 없고, x인곳 ----> T
			else if (!visit[nextx][nexty] && map[nextx][nexty].contains(String.valueOf('x'))) {
				xy e = new xy(nextx, nexty);
				list.add(e);
				visit[nextx][nexty] = true;
			}
		}
		
		while(!list.isEmpty()) {
			xy e = list.poll();
			Glister(e.x, e.y);
		}
	}

	// 공중에 있는 글리스터 좌표 체크
	static void aboveGlister(int x, int y, ArrayList<xy> temp) {
		ArrayDeque<xy> list = new ArrayDeque<xy>();

		if(!visit[x][y]) {
			xy e = new xy(x,y);
			temp.add(e);
			visit[x][y] =true;
		}
		
		for (int i = 0; i < 4; i++) {
			int nextx = x + dx[i];
			int nexty = y + dy[i];

			if (nextx < 0 || nexty < 0 || nextx > r - 1 || nexty > c - 1)
				continue;
			//아직 방문한 적 없고, x인곳 ----> T (떠있는거 중에)
			else if (!visit[nextx][nexty] && map[nextx][nexty].contains(String.valueOf('x'))) {
				xy e = new xy(nextx, nexty);
				list.add(e);
				visit[nextx][nexty] = true;
				temp.add(e);
			}
		}
		
		while(!list.isEmpty()) {
			xy e = list.poll();
			aboveGlister(e.x, e.y,temp);
		}
		
	}

}
