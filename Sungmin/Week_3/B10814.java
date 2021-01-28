import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class B10814 {
	static class OldSort implements Comparable<OldSort>{
		int age;
		int order;
		String s;
		
		public OldSort(int age, String s, int order) {
			this.age=age;
			this.s=s;
			this.order=order;
		}
		
		@Override //-1이면 앞 거, 1이면 뒤 거
		public int compareTo(OldSort Info) {
			if(this.age<Info.age) return -1;
			else if(this.age==Info.age&&this.order<Info.order) return -1;
			return 1;
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			int count=Integer.parseInt(input.readLine());
			ArrayList<OldSort> array = new ArrayList<OldSort>();
			for(int i=0;i<count;i++) {
				String[] s = input.readLine().split(" ");
				OldSort temp = new OldSort(Integer.parseInt(s[0]), s[1], i);
				array.add(temp);
			}
			Collections.sort(array);
			for(int i=0;i<array.size();i++) {
				sb.append(array.get(i).age+" "+array.get(i).s+"\n");
			}
				
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}