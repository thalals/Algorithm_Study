import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B6550 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String s;
		while((s=input.readLine())!=null) {
			boolean flag=false;
			String[] s1=s.split(" ");
			int index=0;
			for(int i=0;i<s1[1].length();i++) {
				if(s1[1].charAt(i)==s1[0].charAt(index)) {
					if(index==s1[0].length()-1) {
						sb.append("Yes\n");
						flag=true;
						break;
					}
					index++;
				}
			}
			if(!flag)sb.append("No\n");
		}
		System.out.print(sb);
		input.close();
	}
}