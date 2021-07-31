package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1212_8진수2진수 {
	
	static String number[];
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		number = br.readLine().split("");
		
		if(number[0].equals("0")) {
			System.out.print(0);
			return;
		}
		
		for(String n : number) {
			change(Integer.parseInt(n));
		}
		
		String result = sb.toString();
		
		while(result.charAt(0) == '0') {
			result = result.substring(1,result.length());
		}
		System.out.println(result);
	}
 static void change(int a) {
		String temp = "";
		
		for(int i=0;i<3;i++) {
			temp=(a%2)+temp;
			a/=2;
		}
		
		sb.append(temp);
		
	}
}
