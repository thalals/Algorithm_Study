package implementation;

import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//직진 아니면 오른쪽 회전 ^ > 
//처음에 직진 -> if(오른쪽 칸이 비어있으면) 방향 오른쪽 회전
public class boj1913_달팽이 {
	
	static int n;
	static int number;
	static int map[][];
	
	//북 동 남 서
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	static int direction = 0;
	static int result[] = new int[2];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		number = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		//1의 좌표
		int x = n/2;
		int y = n/2;
		
		int now =1;
		map[x][y] = now++;
		
		if(number == 1) {
			result[0] = x+1;
			result[1] = y+1;
		}
		while(now != (n*n)+1) {
			//직진
			x = x+dx[direction];
			y = y+dy[direction];
			
			if(now == number) {
				result[0] = x+1;
				result[1] = y+1;
			}
			map[x][y] = now++;
			
			//오른쪽 비어있는지 확인 -> 방향 전환
			int tdirection = direction+1>3 ? 0 : direction+1;
			
			int tx = x+dx[tdirection];
			int ty = y+dy[tdirection];
			if(map[tx][ty]==0) {
				direction+=1;
				if(direction>3)
					direction=0;
			}
			
		}
		
		//output
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1;j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append(map[i][n-1]+"\n");
		}
		
		sb.append(result[0]+" "+result[1]);
		
		System.out.print(sb.toString());
	}

}
