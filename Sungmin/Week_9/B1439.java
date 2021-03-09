import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1439 {
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb=new StringBuilder();
			String[] s = input.readLine().split("");
			int zerocount=0;
			int onecount=0;
			int current=-1;
			for(int i=0;i<s.length;i++) {
				if(i==0) {
					current=Integer.parseInt(s[0]);
					continue;
				}
				if(s[i].equals("0")){
					if(current==0)continue;
					else {
						current=0;
						onecount++;
					}
				}
				else {
					if(current==1)continue;
					else {
						current=1;
						zerocount++;
					}
				}
			}
			if(current==1)onecount++;
			else zerocount++;
			sb.append(Math.min(onecount, zerocount));
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}