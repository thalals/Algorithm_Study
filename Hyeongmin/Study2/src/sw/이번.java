package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 이번 {
	static int result[][];
	static boolean visit[];
	
	static int sum[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp[] = br.readLine().split(" ");
		
		int p = Integer.parseInt(temp[0]);	//컴
		int n = Integer.parseInt(temp[1]);	//인원
		int h = Integer.parseInt(temp[2]);	//시간
		
		result = new int[p][n];
		visit = new boolean[n];
		
		for(int i=0;i<n;i++) {
			temp = br.readLine().split(" ");
			if(Integer.parseInt(temp[1]) > h)
				continue;
			
			result[Integer.parseInt(temp[0])-1][i] = Integer.parseInt(temp[1]);
		}
		
		
		for(int i=0;i<p;i++) {
			Arrays.sort(result[i]);
			int max = 0;
			for(int j=result[i].length;j>0;j--) {
				if(max+result[i][j-1]<=h)
					max+=result[i][j-1];
				else {
					System.out.println(i+1+" "+max*1000);
					continue;
				}
			}
			System.out.println(i+1+" "+max*1000);
			continue;
		}

	}
}
