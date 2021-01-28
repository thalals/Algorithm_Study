package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class person implements Comparable<person>{
	int age;
	String name;
	int index;
	
	person(int age, String name, int index){
		this.age = age;
		this.name = name;
		this.index = index;
	}
	
	@Override
	public int compareTo(person o) {
		if(this.age > o.age)
			return 1;
		else if(this.age == o.age)
			if(this.index > o.index)
				return 1;
		return -1;
	}
}
public class 나이순정렬_10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<person> list = new ArrayList<person>();
		
		for(int i=0;i<n;i++) {
			String a[] = br.readLine().split(" ");
			person p = new person(Integer.parseInt(a[0]),a[1],i);
			list.add(p);
		}
		Collections.sort(list);
		
		for(person p : list)
			System.out.println(p.age+" "+p.name);
		
	}

}
