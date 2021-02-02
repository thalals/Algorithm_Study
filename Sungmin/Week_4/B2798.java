import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class B2798 {
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter output=new BufferedWriter(new OutputStreamWriter(System.out));
			String[] s = input.readLine().split(" ");
			int x=Integer.parseInt(s[0]);
			int num = Integer.parseInt(s[1]);
			String[] temps = input.readLine().split(" ");
			int[] nums = new int[x];
			for(int i=0;i<nums.length;i++) nums[i]=Integer.parseInt(temps[i]);
			int sum=0;
			int max=0;
			for(int i=0;i<nums.length-2;i++) {
				sum=nums[i];
				for(int i1=i+1;i1<nums.length-1;i1++) {
					sum+=nums[i1];
					for(int i2=i1+1;i2<nums.length;i2++) {
						sum+=nums[i2];
						if(sum==num) {
							max=sum;
							break;
						}
						else if(max<sum&&sum<num) max=sum;
						sum-=nums[i2];
					}
					if(sum==num)break;
					sum-=nums[i1];
				}
				if(sum==num)break;
			}
			output.write(String.valueOf(max));
			output.flush();
			output.close();
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}