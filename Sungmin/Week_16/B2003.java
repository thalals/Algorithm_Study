import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] s=input.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int objNum=Integer.parseInt(s[1]);
		int count=0;
		int[] table=new int[n];
		int currentSlice=0;
		s=input.readLine().split(" ");
		for(int i=0;i<n;i++) {
			table[i]=Integer.parseInt(s[i]);
			if(table[i]==objNum)
				count++;
		}
		int windowSize=2;
		while(true) {
			if(windowSize>objNum||windowSize>n)
				break;
			currentSlice=0;
			for(int i=0;i<windowSize;i++)
				currentSlice+=table[i];
			if(currentSlice==objNum)
				count++;
			for(int i=windowSize;i<n;i++) {
				currentSlice=currentSlice-table[i-windowSize]+table[i];
				if(currentSlice==objNum)
					count++;
			}
			windowSize++;
		}
		System.out.print(count);
		input.close();
	}
}
