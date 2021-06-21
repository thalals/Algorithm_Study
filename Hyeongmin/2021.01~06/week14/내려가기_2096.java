package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 내려가기_2096 {
	
	static int map[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int dpmin[][] = new int[2][3];
		int dpmax[][] = new int[2][3];
		
		map = new int[n][3];
		
		for(int i=0;i<n;i++) {
			String temp[] = br.readLine().split(" ");
			map[i][0] = Integer.parseInt(temp[0]);
			map[i][1] = Integer.parseInt(temp[1]);
			map[i][2] = Integer.parseInt(temp[2]);
		}
		/*------------input-----------------------*/
		
		dpmax[0][0] = map[0][0];
		dpmax[0][1] = map[0][1];
		dpmax[0][2] = map[0][2];
		
		dpmin[0][0] = map[0][0];
		dpmin[0][1] = map[0][1];
		dpmin[0][2] = map[0][2];
		
		
		for(int i=1;i<n;i++) {
			dpmax[1][0] = map[i][0] + Math.max(dpmax[0][0], dpmax[0][1]);
			dpmax[1][1] = map[i][1] + Math.max(dpmax[0][2] ,Math.max(dpmax[0][0], dpmax[0][1]));
			dpmax[1][2] = map[i][2] + Math.max(dpmax[0][1], dpmax[0][2]);

			dpmin[1][0] = map[i][0] + Math.min(dpmin[0][0], dpmin[0][1]);
			dpmin[1][1] = map[i][1] + Math.min(dpmin[0][2] ,Math.min(dpmin[0][0], dpmin[0][1]));
			dpmin[1][2] = map[i][2] + Math.min(dpmin[0][1], dpmin[0][2]);
			
			//---------------------------------복사.,, 초기화?
			dpmax[0][0] = dpmax[1][0];
			dpmax[0][1] = dpmax[1][1];
			dpmax[0][2] = dpmax[1][2];
			
			dpmin[0][0] = dpmin[1][0];
			dpmin[0][1] = dpmin[1][1];
			dpmin[0][2] = dpmin[1][2];
		}
		
		if(n==1) 
			System.out.println(Math.max(map[0][2], Math.max(map[0][0], map[0][1])) +" "+ Math.min(map[0][0], Math.min(map[0][1], map[0][2])));

		else
			System.out.println(Math.max(dpmax[1][2], Math.max(dpmax[1][0], dpmax[1][1])) +" "+ Math.min(dpmin[1][0], Math.min(dpmin[1][1], dpmin[1][2])));
	}

}
