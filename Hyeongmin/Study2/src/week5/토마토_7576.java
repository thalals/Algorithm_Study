package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

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
	static int visit[][];
	static ArrayDeque<xy> list = new ArrayDeque<xy>();
	static int map[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		
		String temp[] = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
				
		visit = new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				visit[i][j] = -1;
		
		map= new int [m][n];
		
		for(int i=0;i<m;i++) {
			temp = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				if(map[i][j] == 1) {
					xy a = new xy(i,j);
					list.add(a);
					visit[i][j] = 1;
				}
			}
		}
		
		// 리스트 입력
		
		if(list.isEmpty())
			System.out.println("-1");
		
		else {
			
			bfs(n,m);
		}
		
		System.out.println(count);
		
	}
	public static void bfs(int xsize, int ysize) {
		
		while(!list.isEmpty()) {
			xy t = list.poll();
			
			for(int i=0;i<4;i++) {
				int nextx = t.x+dx[i];
				int nexty = t.y+dy[i];
				
				//맵을 벗어나는 경우
				if(nextx<0 || nexty < 0 || nextx>xsize-1 || nexty > ysize-1)
					continue;
				else if(visit[nextx][nexty]== -1 || map[nextx][nexty] == 0){
					xy temp = new xy(nextx,nexty);
					
					list.offer(temp);
					visit[nextx][nexty] = visit[t.x][t.y]+1;
				}
			}		
		}
	}
	
	

}
