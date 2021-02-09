package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 체스판다시칠하기_1018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a[] = br.readLine().split(" ");
		int n = Integer.parseInt(a[0]);
		int m = Integer.parseInt(a[1]);

		String map[][] = new String[n][m];
		for (int i = 0; i < n; i++) {
			String t[] = br.readLine().split("");

			for (int j = 0; j < m; j++) {
				map[i][j] = t[j];
			}
		}


		int count = 0;
		int min = Integer.MAX_VALUE;

		// 가로
		for (int i = 0; i < n-7; i++) {
			// 세로
			for (int j = 0; j < m-7; j++) {
				
				String copymap[][] = new String[8][8];
				String copymap1[][] = new String[8][8];

				for(int q =0;q<8;q++) {
					for(int w=0;w<8;w++) {
						copymap[q][w] = map[q+i][w+j];
						copymap1[q][w] = map[q+i][w+j];

					}
				}
				count = Math.min(reverse_check(copymap1),map_check(copymap));
				if(count<min)
					min = count;
			}
		}
		if(min==Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(min);
	}
	
	public static int reverse_check(String copymap[][]) {
		int count = 0;

		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {
				if (i == 0) {
					if (j == 0){
						if (copymap[i][j].equals("W"))
							copymap[i][j] = "B";
						else if (copymap[i][j].equals("B"))
							copymap[i][j] = "W";
					}
					else {
						if (copymap[i][j - 1].equals(copymap[i][j])) {
							count+=1;
							if (copymap[i][j].equals("W"))
								copymap[i][j] = "B";
							else if (copymap[i][j].equals("B"))
								copymap[i][j] = "W";
						}
					}
				}
				else {
					if (copymap[i-1][j].equals(copymap[i][j])) {
						count+=1;
						if (copymap[i][j].equals("W"))
							copymap[i][j] = "B";
						else if (copymap[i][j].equals("B"))
							copymap[i][j] = "W";
					}
				}
			}
		}
		return count;
	}
	public static int map_check(String copymap[][]) {
		int count = 0;

		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {
				if (i == 0) {
					if (j == 0)
						continue;
					else {
						if (copymap[i][j - 1].equals(copymap[i][j])) {
							count+=1;
							if (copymap[i][j].equals("W"))
								copymap[i][j] = "B";
							else if (copymap[i][j].equals("B"))
								copymap[i][j] = "W";
						}
					}
				}
				else {
					if (copymap[i-1][j].equals(copymap[i][j])) {
						count+=1;
						if (copymap[i][j].equals("W"))
							copymap[i][j] = "B";
						else if (copymap[i][j].equals("B"))
							copymap[i][j] = "W";
					}
				}
			}
		}
		return count;

	}
}
