//행과 열의 수가 등차 수열

package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class boj1025_제곱수찾기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp[] = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		int[][] map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			 temp= br.readLine().split(" "); 
			for(int j=0;j<m;j++)
				map[i][j] = Integer.parseInt(temp[j]);
		}
		/*----------------------input-----------------------------*/
		
		
	}
}	
