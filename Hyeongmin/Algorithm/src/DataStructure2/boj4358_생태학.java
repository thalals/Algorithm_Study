package DataStructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;


public class boj4358_생태학 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count =0;
		
		TreeMap<String, Integer> list = new TreeMap<String, Integer>();
		
		String tree="";
		while(true) {
			tree = br.readLine();
			if(tree==null || tree.length()==0)
				break;
			count++;
			if(list.containsKey(tree)) {
				list.replace(tree, list.get(tree)+1);
			}
			else
				list.put(tree, 1);
		}
		
		//출력
		for(String name : list.keySet()) {
			double d = (double)(list.get(name)*100) /count;
			
			sb.append(name+" "+String.format("%.4f", d)+"\n");
			
		}
		System.out.println(sb.toString());
	}

}
