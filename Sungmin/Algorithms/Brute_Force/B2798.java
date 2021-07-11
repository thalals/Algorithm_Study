import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class B2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(input.readLine());
		int x=Integer.parseInt(stk.nextToken());
		int num = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(input.readLine());
		int[] nums = new int[x];
		for(int i=0;i<nums.length;i++) nums[i]=Integer.parseInt(stk.nextToken());
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
		System.out.print(max);
		input.close();
	}
}