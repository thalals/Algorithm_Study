/*
 * 전혀 단순하지 않은 순열 문제. 백트래킹을 이용한 풀이+중복을 포함하는 순열을 이용하여 최대값 찾기 실시
 * 만들어진 값이 n을 넘어서는 시점이 break 시점임. 그때를 기준으로 max값을 출력하면 답임
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class B18511 {
	static int max=0;
	static LinkedList<Integer> permutation=new LinkedList<>();
	static boolean flag=false;
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk=new StringTokenizer(input.readLine());
		int n=Integer.parseInt(stk.nextToken());
		int k=Integer.parseInt(stk.nextToken());
		int digit=1;
		stk=new StringTokenizer(input.readLine());
		int[] nums=new int[k];
		for(int i=0;i<k;i++)
			nums[i]=Integer.parseInt(stk.nextToken());
		Arrays.sort(nums);
		while(!flag) {
			flag=false;
			permu(n,digit,nums);
			digit++;
		}
		System.out.print(max);
		input.close();
	}
	static void permu(int n,int r,int[] nums){
		if(permutation.size()==r) {
			StringBuilder sb=new StringBuilder();
			for(int i:permutation)
				sb.append(i);
			int temp=Integer.parseInt(sb.toString());
			if(n<temp)
				flag=true;
			else
				max=temp;
			return;
		}
		for(int i=0;i<nums.length;i++) {
			permutation.add(nums[i]);
			permu(n,r,nums);
			permutation.removeLast();
			if(flag)break;
		}
	}
}