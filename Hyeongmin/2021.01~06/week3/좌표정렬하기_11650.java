package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class map implements Comparable<map>{
	public int x;
	public int y;
	map(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(map t) {
		if(this.x > t.x)
			return 1;	//x 오름차순 정렬
		else if(this.x == t.x)
			if(this.y > t.y)
				return 1;
		return -1;
	}
}

public class 좌표정렬하기_11650 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<map> list = new ArrayList<map>();
		
		for(int i=0;i<n;i++) {
			String[] tmp = br.readLine().split(" ");
			map test = new map(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
			list.add(i, test);
		}
		
		Collections.sort(list);
		for(map i : list)
			System.out.println(i.x+" "+i.y);
		
	}

}
