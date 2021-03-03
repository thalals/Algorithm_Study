import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B1654 {
	
	public static void main(String[] args) {
		try {
			StringBuilder sb = new StringBuilder();
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			String[] s=input.readLine().split(" ");
			int k=Integer.parseInt(s[0]);
			int n=Integer.parseInt(s[1]);
			long max=0;
			long left=0;
			long[] cables=new long[k];
			for(int i=0;i<k;i++)
				cables[i]=Integer.parseInt(input.readLine());
			long right=Long.MAX_VALUE;
			while(left<=right) {
				long mid=(left+right)/2;
				long result=0;
				for(int i=0;i<k;i++)
					result=result+(cables[i]/mid);
				if(result>=n) {
					left=mid+1;
					if(mid>max)max=mid;
				}
				else right=mid-1;
			}
			sb.append(max);
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}