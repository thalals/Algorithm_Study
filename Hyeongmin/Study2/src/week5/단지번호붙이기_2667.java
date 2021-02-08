package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class 단지번호붙이기_2667 {

	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	
	static int count =0;
	
	static ArrayList<Integer> result = new ArrayList<Integer>();
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int map[][] = new int[n][n];
		
		for(int i=0;i<n;i++) {
			String temp[] = br.readLine().split("");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		visit = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1 && !visit[i][j]) {
					dfs(i,j,map,n);
					
					result.add(count);
					count=0;
				}
			}
		}
		System.out.println(result.size());
		Collections.sort(result);
		for(int a : result)
			System.out.println(a);
	}
	
	public static void dfs(int x,int y, int map[][], int size) {
		if(visit[x][y] || map[x][y] ==0) 
			return;
		
		visit[x][y] = true;
		if(map[x][y] == 1)
			count++;
		
		for(int i =0;i<4;i++) {
			int nextx = x+dx[i];
			int nexty = y+dy[i];
			
			//map을 벗어나는 경우
			if(nextx<0 || nexty<0 || nextx >=size || nexty >=size)
				continue;
			
			
			dfs(nextx,nexty,map,size);
		}
		
		
		
	}
}
