/*
 * 배제조건 개빡세네 이거. 입력조건에도 배제조건 붙어야되는 걸 나중에 알아버림
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class B2503 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(input.readLine());
		String[] nums=new String[n];
		int[] strikes=new int[n];
		int[] balls=new int[n];
		int count=0;
		for(int i=0;i<n;i++) {
			StringTokenizer stk = new StringTokenizer(input.readLine());
			nums[i]=stk.nextToken();
			strikes[i]=Integer.parseInt(stk.nextToken());
			balls[i]=Integer.parseInt(stk.nextToken());
		}
		for(int i=111;i<=999;i++) {
			boolean wrong=false;
			String temp=String.valueOf(i);
			if(temp.charAt(0)==temp.charAt(1)||temp.charAt(1)==temp.charAt(2)||temp.charAt(0)==temp.charAt(2)||
					temp.charAt(0)=='0'||temp.charAt(1)=='0'||temp.charAt(2)=='0')
				continue;
			for(int i1=0;i1<n;i1++) {
				if(!hit(nums[i1],temp,strikes[i1],balls[i1])) {
					wrong=true;
					break;
				}
			}
			if(!wrong)
				count++;
		}
		System.out.print(count);
		input.close();
	}
	static boolean hit(String nums, String obj, int strike, int ball) {
		int tempstrike=0;
		int tempball=0;
		for(int i=0;i<3;i++) {
			for(int i1=0;i1<3;i1++) {
				if(i1==i) {
					if(nums.charAt(i1)==obj.charAt(i))
						tempstrike++;
				}
				else if(nums.charAt(i1)==obj.charAt(i))
					tempball++;
			}
		}
		if(tempstrike!=strike||tempball!=ball)return false;
		return true;
	}
}