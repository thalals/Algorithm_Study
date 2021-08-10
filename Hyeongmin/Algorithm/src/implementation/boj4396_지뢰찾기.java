package implementation;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;

class coordinate{
	int x;
	int y;
	coordinate(int x, int y){
		this.x =x;
		this.y=y;
	}
}

public class boj4396_Áö·ÚÃ£±â {
	static String boom[][];
	static String map[][];
	static boolean BoomFlag = false;
	static ArrayList<coordinate> boomlist = new ArrayList<coordinate>();
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		boom = new String[n][n];
		map = new String[n][n];
		for(int i=0;i<n;i++) {
			String t[] = br.readLine().split("");
			for(int j=0;j<t.length;j++) {
				boom[i][j] = t[j];
				if(t[j].equals("*"))
					boomlist.add(new coordinate(i, j));
			}
		}
		
		//input
		for(int i=0;i<n;i++) {
			String t[] = br.readLine().split("");
			for(int j=0;j<t.length;j++) {
				if(t[j].equals("x")) {
					int number = search(i, j);
					map[i][j] = Integer.toString(number);
				}
				else
					map[i][j] = ".";
			}
		}
		
		if(BoomFlag) {
			for(coordinate a : boomlist) {
				map[a.x][a.y] = "*";
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				sb.append(map[i][j]);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	//ÁÖº¯ ÆøÅº °³¼ö Ã¼Å©
	public static int search(int x, int y) {
		int result =0;
		if(boom[x][y].equals("*")) {
			BoomFlag = true;
			return -1;
		}
		
		for(int i=x-1;i<x+2;i++) {
			for(int j=y-1;j<y+2;j++) {
				if(i<0 || j<0 || i>=n || j>=n)
					continue;
				if(boom[i][j].equals("*"))
					result++;
			}
		}
		return result;
	}
}
