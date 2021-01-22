package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수정렬하기_2750 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int a[] = new int[n];
		for(int i=0;i<n;i++)
			a[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(a);
		
		for(int s : a)
			System.out.println(s);
	}

}
