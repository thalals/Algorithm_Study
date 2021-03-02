import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B18429 {
	static int[] nums;
	static boolean[] allocation;
	static int sum=0;
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			String[] s = input.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int k=Integer.parseInt(s[1]);
			s=input.readLine().split(" ");
			nums=new int[n];
			allocation = new boolean[n];
			for(int i=0;i<n;i++) nums[i]=Integer.parseInt(s[i]);
			NandK(n,k,0,0);
			System.out.print(sum);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	static void NandK(int n, int k, int count, int dif) {
		if(dif<0) return;
		if(count==n) {
			sum++;
			return;
		}
		for(int i=0;i<n;i++) {
			if(allocation[i])continue;
			allocation[i]=true;
			NandK(n,k,count+1,dif+nums[i]-k);
			allocation[i]=false;
		}
	}
}