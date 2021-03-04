import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class B1931 {
	static class Conference implements Comparable<Conference>{
		int start;
		int end;
		
		@Override
		public int compareTo(Conference c) {
			if(this.end>c.end) return 1;
			else if(this.end==c.end&&this.start>c.start) return 1;
			return -1;
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			int count=Integer.parseInt(input.readLine());
			ArrayList<Conference> array = new ArrayList<Conference>();
			for(int i=0;i<count;i++) {
				String[] s = input.readLine().split(" ");
				Conference temp=new Conference();
				temp.start=Integer.parseInt(s[0]);
				temp.end=Integer.parseInt(s[1]);
				array.add(temp);
			}
			Collections.sort(array);
			int result=0;
			int currenttime=0;
			for(int i=0;i<array.size();i++) {
				if(currenttime<=array.get(i).start) {
					result++;
					currenttime=array.get(i).end;
				}
			}
			sb.append(result);
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}