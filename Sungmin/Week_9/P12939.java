import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12939 {
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			String[] s = input.readLine().split(" ");
			int[] nums=new int[s.length];
			for(int i=0;i<nums.length;i++)nums[i]=Integer.parseInt(s[i]);
			int max=nums[0];
			int min=nums[0];
			for(int i=1;i<nums.length;i++) {
				if(max<nums[i])max=nums[i];
				if(min>nums[i])min=nums[i];
			}
			String ans=String.valueOf(min)+" "+String.valueOf(max);
			System.out.print(ans);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}