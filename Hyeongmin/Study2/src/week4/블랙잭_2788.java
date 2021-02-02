package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class ∫Ì∑¢¿Ë_2788 {

	static int max = -Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String b[] = br.readLine().split(" ");
		int n = Integer.parseInt(b[0]);
		int m = Integer.parseInt(b[1]);

		int temp[] = new int[n];
		boolean check[] = new boolean[n];
		
		b = br.readLine().split(" ");
		
		for(int i=0;i<n;i++)
			temp[i] = Integer.parseInt(b[i]);
		
		Arrays.sort(temp);
		
		for(int i=0;i<n-2;i++) {
			if(!check[i]) { 
				check[i] = true;
				
				for(int j=0;j<n-1;j++) {
					if(!check[j]) {
						check[j] = true;
						
						for(int k=0;k<n;k++) {
							if(!check[k]) {
								if(temp[i]+temp[j]+temp[k]<=m && temp[i]+temp[j]+temp[k]>max)
									max = temp[i]+temp[j]+temp[k];
							}
						}
						check[j] = false;
					}
				}
				check[i] = false;
			}
		}
		
		System.out.println(max);
	}

}
