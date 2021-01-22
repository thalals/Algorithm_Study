package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ¾ËÆÄºª°³½º_10808 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int result[] = new int[26];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split("");
		
		for(String a : s) {
			int temp = a.charAt(0)-97;
			result[temp]+=1;
		}
		for(int a : result)
			System.out.print(a+" ");
	}

}
