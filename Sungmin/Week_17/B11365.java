import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11365 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		while(true) {
			String s=input.readLine();
			if(s.equals("END"))break;
			for(int i=s.length()-1;i>=0;i--)
				sb.append(s.charAt(i));
			sb.append("\n");
		}
		System.out.print(sb);
		input.close();
	}
}
