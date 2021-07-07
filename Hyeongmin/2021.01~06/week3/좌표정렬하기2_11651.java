package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


class map1 implements Comparable<map1>{
	int x;
	int y;
	map1(int x,int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(map1 t) {
		if(this.y > t.y)	// y오름차순
			return 1;
		
		else if(this.y==t.y) {	//x내림차순
			if(this.x > t.x)
				return 1;
		}
		
		return -1;
	}
}
public class 좌표정렬하기2_11651 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<map1> list = new ArrayList<map1>();
		
		for(int i=0;i<n;i++) {
			String a[] = br.readLine().split(" ");
			
			map1 s = new map1(Integer.parseInt(a[0]), Integer.parseInt(a[1]));
			list.add(s);
		}
		
		Collections.sort(list);
	
		for(map1 q : list)
			System.out.println(q.x+" "+q.y);
	}

}
