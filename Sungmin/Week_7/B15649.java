import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15649 {
	static StringBuilder sb=new StringBuilder();
	static int[] nums;
	static boolean[] allocation;
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			String[] s = input.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int m=Integer.parseInt(s[1]);
			nums=new int[m];
			allocation = new boolean[n];
			NandM(n,m,0);
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	static void NandM(int n, int m, int count) {
		if(count==m) {
			for(int i=0;i<m;i++) sb.append(nums[i]+" ");
			sb.append("\n");
			return;
		}
		for(int i=0;i<n;i++) {
			if(allocation[i])continue;
			allocation[i]=true;
			nums[count]=i+1;
			NandM(n,m,count+1);
			allocation[i]=false;
		}
	}
}