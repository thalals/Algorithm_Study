import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11399 {
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb=new StringBuilder();
			int n=Integer.parseInt(input.readLine());
			int[] people=new int[n];
			int count=0;
			String[] s=input.readLine().split(" ");
			for(int i=0;i<n;i++) people[i]=Integer.parseInt(s[i]);
			Arrays.sort(people);
			for(int i=0;i<n;i++)
				for(int i1=0;i1<=i;i1++) count+=people[i1];
			sb.append(count);
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}