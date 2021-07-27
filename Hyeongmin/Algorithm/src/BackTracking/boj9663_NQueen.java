package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj9663_NQueen {
	static int n;
	static int map[][];
	static boolean visit[][];
	static int result =0;
	
	static int queen[] = new int[16];	//queen[열] = 행

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visit = new boolean[n][n];
		
		dfs(0,0);
		
//		Arrays.fill(queen, -1);
		
//		batch(0);
		System.out.println(result);
	}
	
	//idx : 행
	public static void batch(int idx) {
		if(idx == n-1) {
			result++; 
			return;
		}
		//열에 배치
		for(int i=0;i<n;i++) {
			//해당 열을 방문하지 않았다면
			if(queen[i] == -1) {
				queen[i] = idx;
				
				if(check(idx, i))	//x,y
					batch(idx+1);
				
				queen[i] = -1;
			}
		}	
//		batch(idx+1);
	}
	
	//열은 중복되지 않음
	//행, 대각선 퀸 존재하는지 체크
	//type(x,y) : 행 열
	public static boolean check(int x, int y) {
		//이전 열까지 확인
		for(int i=0;i<y;i++) {
			
			//각 열 중에 행의 위치가 같거나 대각선의 길이가 같은 것
			if(queen[i]==queen[y] || Math.abs(i-y) == Math.abs(queen[i] - queen[y]) ) 
				return false;
		}
		
		return true;
	}
	
	
	public static void dfs (int cnt, int q) {
		if(cnt == n*n) {
			if(q==n)
				result++;
			return;
		}
		if(q==n) {
			result++;
			return;
		}
		
		
		int x = cnt/n;
		int y = cnt%n;
		
		
		if(!visit[x][y]) {
			if(checking(x,y)) {
//				InVisit(x,y);
				visit[x][y] = true;
				dfs(cnt+1, q+1);
//				OutVisit(x, y);
			}
		}
		dfs(cnt+1,q);
	}
	public static boolean checking(int x, int y) {
		//행 열 대각선 확인
		//행
		for(int i=0;i<n;i++) {
			if(visit[i][y]==true || visit[x][i]==true )
				return false;
			if(x-i>=0 && y+i<n && visit[x-i][y+i]==true)
				return false;
			if(x+i<n && y-i>=0 && visit[x+i][y-i] == true)
				return false;
		}
		
		return true;
	}
	public static void InVisit(int x, int y) {
		for(int i=0;i<n;i++) {
			visit[i][y] = true;
			visit[x][i] = true;
			
			if(x-i>=0 && y-i >=0) 
				visit[x-i][y-i] = true;
			
			if(x+i<n && y+i<n)
				visit[x+i][y+i] = true;
			
			if(x-i>=0 && y+i<n)
				visit[x-i][y+i] = true;
			if(x+i<n && y-i>=0)
				visit[x+i][y-i] = true;

		}
	}

	public static void OutVisit(int x, int y) {
		for(int i=0;i<n;i++) {
			visit[i][y] = false;
			visit[x][i] = false;
			
			if(x-i>=0 && y-i >=0) 
				visit[x-i][y-i] = false;
			
			if(x+i<n && y+i<n)
				visit[x+i][y+i] = false;
			if(x-i>=0 && y+i<n)
				visit[x-i][y+i] = false;
			if(x+i<n && y-i>=0)
				visit[x+i][y-i] = false;
		}
	}

}
