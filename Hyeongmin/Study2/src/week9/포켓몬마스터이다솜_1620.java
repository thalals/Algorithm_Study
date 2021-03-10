package week9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


class poketmon implements Comparable<poketmon>{
	 int number;
	String name;
	
	public poketmon() {
	}
	
	poketmon(int number, String name){
		this.number = number;
		this.name = name;
	}

	@Override
	public int compareTo(poketmon o) {
		int i =0;
		while(true) {
			if(this.name.charAt(i) > o.name.charAt(i))
				return 1;
			else if(this.name.charAt(i) == o.name.charAt(i)) {
				i++;
			}
			else
				return -1;
		}
	}
}
public class 포켓몬마스터이다솜_1620 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String temp[] = br.readLine().split(" ");
		
		int a= Integer.parseInt(temp[0]);
		int b= Integer.parseInt(temp[1]);
		
		poketmon dict[] = new poketmon[a+1];
		
		for(int i=1;i<=a;i++) {
			poketmon p = new poketmon(i,br.readLine());
			dict[i] = p;
		}
		
		ArrayList<poketmon> sort_dict =new ArrayList<poketmon>();
		for(poketmon t : dict)
			sort_dict.add(t);
//		for(int i=1;i<=a;i++) {
//			sort_dict[i] = dict[i];
//		}
		
		Collections.sort(sort_dict);
		
		for(int i=0;i<b;i++) {
			String s =br.readLine();
			//문자열 숫자인지 판별 isdisit
			if(Character.isDigit(s.charAt(0))) {
				int number = Integer.parseInt(s);
				
				bw.append(dict[number].name+"\n");
			}
			else {
				bw.append(binary_search(0, sort_dict.size(), sort_dict, s)+"\n");
				
			}
			
		}
		
		bw.close();
		br.close();
		
	}
	
	public static int binary_search(int start, int end, ArrayList<poketmon> dic, String key) {
		int mid = (start+end)/2;
		
		if(mid>end)
			return 0;
		
		if(dic.get(mid).name.contains(key))
			return dic.get(mid).number;
		else {
			binary_search(start, mid, dic, key);
			binary_search(mid+1, end, dic, key);
		}
		return -1;
	}
	
}
