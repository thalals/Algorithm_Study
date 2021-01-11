import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class B9093 {
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter output=new BufferedWriter(new OutputStreamWriter(System.out));
			int x=Integer.parseInt(input.readLine());
			for(int i=0;i<x;i++) {
				String[] s = input.readLine().split(" ");
				for(int i1=0;i1<s.length;i1++) {
					for(int i2=s[i1].length()-1;i2>=0;i2--)
						output.write(s[i1].charAt(i2));
					output.write(" ");
				}
				output.write("\n");
			}
			output.flush();
			output.close();
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}