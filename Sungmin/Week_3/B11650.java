import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class B11650 {
	static class XY implements Comparable<XY>{
		int x;
		int y;
		
		@Override
		public int compareTo(XY xy) {
			if(this.x>xy.x) return 1;
			else if(this.x==xy.x&&this.y>xy.y) return 1;
			return -1;
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			int count=Integer.parseInt(input.readLine());
			ArrayList<XY> array = new ArrayList<XY>();
			for(int i=0;i<count;i++) {
				XY temp = new XY();
				String[] s = input.readLine().split(" ");
				int x=Integer.parseInt(s[0]);
				int y=Integer.parseInt(s[1]);
				temp.x=x;
				temp.y=y;
				array.add(temp);
			}
			Collections.sort(array);
			for(int i=0;i<array.size();i++)
				sb.append(array.get(i).x+" "+array.get(i).y+"\n");
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}