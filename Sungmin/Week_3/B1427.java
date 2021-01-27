import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class B1427 {
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			String s = input.readLine();
			int[] nums = new int[s.length()];
			for(int i=0;i<nums.length;i++) nums[i]=s.charAt(i)-48;
			Arrays.sort(nums);
			for(int i=nums.length-1;i>=0;i--) sb.append(nums[i]);
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}