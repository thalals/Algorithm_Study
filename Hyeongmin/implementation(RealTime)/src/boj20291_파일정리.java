import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class boj20291_파일정리 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		TreeMap<String,Integer> treeset = new TreeMap<String, Integer>();
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i=0;i<n;i++) {
			String temp = br.readLine();

			String extention ="";
			
			boolean check =false;
			for(int j=0;j<temp.length();j++) {
				if(temp.charAt(j)=='.')
					check=true;
				
				if(check) {
					extention = temp.substring(j+1, temp.length());
					break;
				}
			}
			
			if(treeset.containsKey(extention)) {
				int count = treeset.get(extention);
				treeset.replace(extention, count+1);
			}
			else
				treeset.put(extention,1);
			
		}

		for(String key : treeset.keySet()) {
			sb.append(key+" "+treeset.get(key)+"\n");
		}
		System.out.println(sb.toString());
	}

}
