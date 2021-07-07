import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class B2231 {
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter output=new BufferedWriter(new OutputStreamWriter(System.out));
			int x = Integer.parseInt(input.readLine());
			int result=0;
			int temp,sum;
			for(int i=1;i<x;i++) {
				temp=i;
				sum=i;
				result=temp;
				while(temp!=0) {
					sum=sum+(temp%10);
					temp/=10;
				}
				if(sum!=x) result=0;
				else break;
			}
			output.write(String.valueOf(result));
			output.flush();
			output.close();
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}