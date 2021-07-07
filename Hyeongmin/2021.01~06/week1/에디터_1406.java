package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ListIterator;

public class ¿¡µðÅÍ_1406 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String tmp[] = br.readLine().split("");
		
		Deque<String> left = new ArrayDeque<String>();
		Deque<String> right = new ArrayDeque<String>();
		
		LinkedList<String> l_list = new LinkedList<String>();

		int n = Integer.parseInt(br.readLine());
		for(int i =0;i<tmp.length;i++)
			l_list.add(tmp[i]);
		
		//listiteration
		ListIterator<String> iter = l_list.listIterator();
		
		while(iter.hasNext())
			iter.next();
		
		for(int i=0;i<n;i++) {
			String key[] = br.readLine().split(" ");
			
			switch (key[0]) {
			case "L":
				if(iter.hasPrevious())
					iter.previous();
				break;

			case "D" :
				if(iter.hasNext())
					iter.next();
				
				break;
				
				
			case "B" :
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			
			case "P" :
				iter.add(key[1]);
				break;
			}
		}
		
//		while(!right.isEmpty()) 
//			left.push(right.poll());
//		
//		while(!left.isEmpty())
//			System.out.printf(left.pollLast());
		
		for(String a:l_list)
			bw.append(a);
		bw.close();
		br.close();
	}

}
