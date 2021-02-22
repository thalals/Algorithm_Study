import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1920 {
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			int n=Integer.parseInt(input.readLine());
			int[] nums = new int[n];
			String[] stringinput = input.readLine().split(" ");
			for(int i=0;i<n;i++)
				nums[i]=Integer.parseInt(stringinput[i]);
			Arrays.sort(nums);
			int m=Integer.parseInt(input.readLine());
			stringinput=input.readLine().split(" ");
			for(int i=0;i<m;i++) {
				int number=Integer.parseInt(stringinput[i]);
				sb.append(binarySearch(nums, number)+"\n");
			}
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	static int binarySearch(int[] N, int number) {
		int first=0;
		int last=N.length-1;
		int mid=0;
		while(first<=last) {
			mid=(first+last)/2;
			if(number==N[mid]) return 1;
			else {
				if(number<N[mid]) last=mid-1;
				else first=mid+1;
			}
		}
		return 0;
	}
}