package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class xy {
	int x;
	int y;
	
	xy(){
		
	}
	xy(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class 토마토_7576 {

	static int count  =0;
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static boolean visit[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		
		String temp[] = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		ArrayList<xy> list = new ArrayList<xy>();
		visit = new boolean[m+1][n+1];
		int map[][] = new int [m][n];
		
		for(int i=0;i<n;i++) {
			temp = br.readLine().split(" ");
			for(int j=0;j<m;i++) {
				map[i][j] = Integer.parseInt(temp[j]);
				if(map[i][j] == 1) {
					xy a = new xy(i,j);
					list.add(a);
				}
			}
		}
		
		if(list.isEmpty())
			System.out.println("-1");
		else {
			for(xy b : list) {
				dfs(b.x, b.y,map,n,m);
			}
		}
		
		System.out.println(count);
		
	}
	
	public static void dfs(int x, int y, int map[][], int xsize, int ysize) {
		if(visit[x][y] || map[x][y] != 0) 
			return;
		
		count+=1;
		
		for(int i=0;i<4;i++) {
			int nextx = x+dx[i];
			int nexty = y+dy[i];
			
			//맵을 벗어나는 경우
			if(nextx<0 || nexty < 0 || nextx>xsize || nexty > ysize)
				continue;
			
			dfs(nextx, nexty,map,xsize,ysize);

		}
	}

}
