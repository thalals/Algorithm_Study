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

public class ≈‰∏∂≈‰_7576 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		
		String temp[] = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		ArrayList<xy> list = new ArrayList<xy>();
		
		int map[][] = new int [m][n];
		
		for(int i=0;i<m;i++) {
			temp = br.readLine().split(" ");
			for(int j=0;j<n;i++) {
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
				
			}
		}
		
		
	}
	
	public static void dfs() {
		
	}

}
