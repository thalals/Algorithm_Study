package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

class map2 implements Comparable<map2>{
	String a;
	
	map2(String a){
		this.a =a ;
	}

	@Override
	public int compareTo(map2 o) {
		if(this.a.length() > o.a.length())
			return 1;
		else if(this.a.length() == o.a.length()) {
			for(int i=0;i<a.length();i++) {
				return this.a.compareTo(o.a);	//두 문자열 사전순 비교 int형 리턴
//				if(this.a.charAt(i) > o.a.charAt(i))
//					return 1;	
			}
		}
		return -1;
	}
	
}
public class 단어정렬_1181 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		TreeSet<map2> list= new TreeSet<map2>();
		for(int i=0;i<n;i++) {
			map2 t= new map2(br.readLine());
			list.add(t);
		}
		
		for(map2 s : list)
			System.out.println(s.a);
	}

}
