package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj5597_과제안내신분 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=1;i<=30;i++)
			list.add(i);
		
		int number = 28;
		while(number-->0) {
			int a = Integer.parseInt(br.readLine());
			
			list.remove(list.indexOf(a));
		}
		
		for(int a : list)
			System.out.println(a);
	}

}
