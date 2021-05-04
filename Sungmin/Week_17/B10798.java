import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B10798 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		char[][] array=new char[15][15];
		for(int i=0;i<15;i++) {
			for(int i1=0;i1<15;i1++)
				array[i][i1]='@';
		}
		int max=0;
		for(int i=0;i<5;i++) {
			String s=input.readLine();
			if(max<s.length()) max=s.length();
			for(int i1=0;i1<s.length();i1++)
				array[i][i1]=s.charAt(i1);
		}
		for(int i=0;i<max;i++) {
			for(int i1=0;i1<5;i1++) {
				if(array[i1][i]=='@')continue;
				sb.append(array[i1][i]);
			}
		}
		System.out.print(sb);
		input.close();
	}
}