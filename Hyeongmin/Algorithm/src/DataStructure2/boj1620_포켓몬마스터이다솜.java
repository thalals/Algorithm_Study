package DataStructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class boj1620_포켓몬마스터이다솜 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String temp[] = br.readLine().split(" ");
		String numlist[];
		
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		numlist = new String[n+1];
		
		int i = 1;
		
		while(n-->0) {
			String name = br.readLine();
			list.put(name, i);
			numlist[i++]=name;
		}
		while(m-->0) {
			String quiz = br.readLine();
			
			if('0'<=quiz.charAt(0) && quiz.charAt(0)<='9') {
				sb.append(numlist[Integer.parseInt(quiz)]+'\n');
			}
			else {
				sb.append(list.get(quiz)+"\n");
			}
				
				
		}
		
		System.out.println(sb.toString());
	}

}
