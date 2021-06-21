package week15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Çà·ÄÁ¦°ö_10830 {
	static int map[][];
	static int count=0;
	static int n=0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String temp[] = br.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]);
		count = Integer.parseInt(temp[1]);
		
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			temp = br.readLine().split(" ");
			for(int j=0;j<n;j++)
				map[i][j] = Integer.parseInt(temp[j]);
		}
		/*--------input-----------*/
		
		int result[][] = new int[n][n];
				
		result = binary(map, count);

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				bw.append(result[i][j]+" ");
			bw.append("\n");
		}
		
		bw.close();
		br.close();
	}
	
	public static int[][] binary(int tmap[][], int count) {
		int temp[][] = new int[n][n];
		
		if(count ==0)
			return temp;
		else if(count==1)
			return map;
		
		
		else if(count==2) {
			temp = mul(map, map);
			return temp;
		}
		else if(count>2) {
			//Â¦¼ö
			if(count%2==0) {
				temp = binary(tmap, count/2);
				return mul(temp,temp);
			}
			//È¦¼ö
			else {
				temp = binary(tmap, (count-1));
				return mul(tmap,temp);

			}
		}

		
		return temp;
	}
	
	public static int[][] mul(int a[][], int b[][]){
		
		int temp[][] = new int[n][n];

		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					temp[i][j] += (a[i][k] * b[k][j]) % 1000;
				}
				temp[i][j] = temp[i][j]%1000;
			}
		}
		
		return temp;
	}
	
}
