package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class dot{
	int x;
	int y;
	dot(int x, int y){
		this.x =x;
		this.y=y;
	}
}
public class boj2578_빙고 {
	
	static int map[][] = new int[5][5];
	static boolean visit[][] = new boolean[5][5];
	
	static HashMap<Integer, dot> position = new HashMap<Integer, dot>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp[];
		
		//bingo
		for(int i=0;i<5;i++) {
			temp = br.readLine().split(" ");
			for(int j=0;j<5;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				dot p = new dot(i,j);
				
				position.put(Integer.parseInt(temp[j]), p);
			}
		}
		
		int count=0;
		int result=0;
		//call number
		for(int i=0;i<5;i++) {
			temp = br.readLine().split(" ");
			for(String a : temp) {
				int number = Integer.parseInt(a);
				result++;
				//숫자 지우기(방문)
				dot n = position.get(number);
				visit[n.x][n.y] = true;
				
				//그 숫자로부터 행 열 대각선 빙고 확인
				//2,2 는 대각선도 확인
				if(bingo1(n.x, n.y) )
					count++;
				if(bingo2(n.x, n.y) )
					count++;
				//대각선 상에 있을 때
				if(n.x-n.y==0) {
					if(bingo3(n.x, n.y))
						count++;
				}
				if(n.y+n.x==4) {
					if(bingo4(n.x, n.y))
						count++;
				}
				
				if(count>=3) {
					System.out.println(result);
					return;
				}
					
				
			}
		}
		
	}
	
	//빙고 확인
	public static boolean bingo1(int x, int y) {
		//행
		for(int i=0;i<5;i++) {
			if(!visit[x][i])
				return false;
		}
		return true;
	}
	public static boolean bingo2(int x, int y) {
		//열
		for(int i=0;i<5;i++) {
			if(!visit[i][y])
				return false;
		}
		return true;
	}
	
	public static boolean bingo3(int x, int y) {
		//왼쪽대각선
		x=0;
		y=0;
		for(int i=0;i<5;i++) {
			if(!visit[x++][y++])
				return false;
		}
		return true;

	}
	public static boolean bingo4(int x, int y) {
		//오른쪽 대각선 x+1 y-1
		
		x=0;
		y=4;
		for(int i=0;i<5;i++) {
			if(!visit[x++][y--])
				return false;
		}

		return true;
	}
}
