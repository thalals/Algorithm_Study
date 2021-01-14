import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B2455 {
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder output = new StringBuilder();
			String[] s = input.readLine().split(" ");
			int max=Integer.parseInt(s[1]);
			int current=max;
			int in,out;
			for(int i=0;i<3;i++) {
				s=input.readLine().split(" ");
				out=Integer.parseInt(s[0]);
				in=Integer.parseInt(s[1]);
				current=current-out+in;
				if(current>max)max=current;
			}
			output.append(max);
			System.out.print(output);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}