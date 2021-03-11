import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class B18870 {
	static class HashNum implements Comparable<HashNum>{
		int index;
		int num;
		
		HashNum(int num, int index){
			this.index=index;
			this.num=num;
		}
		@Override
		public int compareTo(HashNum Word) {
			if(this.num<Word.num)return -1;
			else if(this.num>Word.num)return 1;
			return 0;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int x=Integer.parseInt(input.readLine());
		HashNum[] nums=new HashNum[x];
		int[] result=new int[x];
		String[] s=input.readLine().split(" ");
		for(int i=0;i<x;i++)
			nums[i]=new HashNum(Integer.parseInt(s[i]),i);
		Arrays.sort(nums);
		for(int i=0;i<x;i++) {
			if(i==0) result[nums[i].index]=0;
			else if(nums[i-1].num==nums[i].num)
				result[nums[i].index]=result[nums[i-1].index];
			else
				result[nums[i].index]=result[nums[i-1].index]+1;
		}
		for(int i=0;i<x;i++)sb.append(result[i]+" ");
		System.out.print(sb);
		input.close();
	}
}