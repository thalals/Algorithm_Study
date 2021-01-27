import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class B10989 {
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			int x=Integer.parseInt(input.readLine());
			int[] nums = new int[x];
			for(int i=0;i<x;i++) nums[i]=Integer.parseInt(input.readLine());
			Arrays.sort(nums);
			for(int i=0;i<x;i++) sb.append(nums[i]+"\n");
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}