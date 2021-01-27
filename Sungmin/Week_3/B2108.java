import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class B2108 {
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			ArrayList<Integer> mean = new ArrayList<Integer>();
			int avr=0;
			int meanMax=0;
			int x=Integer.parseInt(input.readLine());
			int[] nums = new int[x];
			int[] forMean = new int[8001];
			for(int i=0;i<x;i++) {
				nums[i]=Integer.parseInt(input.readLine());
				forMean[nums[i]+4000]++;
				avr+=nums[i];
			}
			for(int i=0;i<forMean.length;i++) if(meanMax<forMean[i]) meanMax=forMean[i];
			for(int i=0;i<forMean.length;i++) if(meanMax==forMean[i]) mean.add(i-4000);
			Collections.sort(mean);
			Arrays.sort(nums);
			sb.append(String.format("%.0f", avr/(double)x)+"\n");
			sb.append(nums[(x-1)/2]+"\n");
			if(mean.size()>=2) sb.append(mean.get(1)+"\n");
			else sb.append(mean.get(mean.size()-1)+"\n");
			if(nums.length>=2) sb.append((nums[nums.length-1]-nums[0])+"\n");
			else sb.append("0");
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}