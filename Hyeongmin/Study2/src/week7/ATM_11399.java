package week7;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ATM_11399 {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		
		int p[] = new int[n];
		for(int i=0;i<n;i++) {
			p[i] = sc.nextInt();
		}
		
		Arrays.parallelSort(p);
		
		int sum=0;
		int result=0;
		
		for(int i=0;i<n;i++) {
			sum+=p[i];
			
			result+=sum;
		}
		
		System.out.println(result);
	}

}
