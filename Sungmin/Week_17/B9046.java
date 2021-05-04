import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B9046 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(input.readLine());
		for(int i=0;i<n;i++) {
			boolean flag=false;
			int[] alpha=new int[26];
			String s =input.readLine();
			for(int i1=0;i1<s.length();i1++) {
				if(s.charAt(i1)==' ')continue;
				alpha[s.charAt(i1)-97]++;
			}
			int max=alpha[0];
			int index=0;
			for(int i1=1;i1<26;i1++) {
				if(max<alpha[i1]) {
					index=i1;
					max=alpha[i1];
				}
			}//최대값찾기
			for(int i1=0;i1<26;i1++) {
				if(max==alpha[i1]&&index!=i1) {
					flag=true;
					break;
				}
			}
			if(flag) sb.append("?\n");
			else sb.append((char)(index+97)+"\n");
		}
		System.out.print(sb);
		input.close();
	}
}