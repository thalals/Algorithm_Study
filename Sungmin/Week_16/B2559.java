import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2559 {

	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] s=input.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int count=Integer.parseInt(s[1]);
		int[] table=new int[n];
		int maxSlice=0;
		int currentSlice=0;
		s=input.readLine().split(" ");
		for(int i=0;i<n;i++) {
			table[i]=Integer.parseInt(s[i]);
			if(i<count)
				currentSlice+=table[i];
		}
		maxSlice=currentSlice;
		for(int i=count;i<n;i++) {
			currentSlice=currentSlice-table[i-count]+table[i];
			if(currentSlice>maxSlice)
				maxSlice=currentSlice;
		}
		System.out.print(maxSlice);
		input.close();
	}
	
}
