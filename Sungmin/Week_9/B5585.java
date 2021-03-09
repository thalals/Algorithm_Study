import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5585 {
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb=new StringBuilder();
			int change=1000-Integer.parseInt(input.readLine());
			int count=0;
			while(change!=0) {
				if(change/500>=1) {
					count+=change/500;
					change%=500;
				}
				else if(change/100>=1) {
					count+=change/100;
					change%=100;
				}
				else if(change/50>=1) {
					count+=change/50;
					change%=50;
				}
				else if(change/10>=1) {
					count+=change/10;
					change%=10;
				}
				else if(change/5>=1) {
					count+=change/5;
					change%=5;
				}
				else {
					count+=change;
					change=0;
				}
			}
			sb.append(count);
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}