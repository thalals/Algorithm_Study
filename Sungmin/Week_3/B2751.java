import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class B2751 {
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			int x=Integer.parseInt(input.readLine());
			ArrayList<Integer> nums = new ArrayList<Integer>();
			for(int i=0;i<x;i++) {
				int temp = Integer.parseInt(input.readLine());
				nums.add(temp);
			}
			Collections.sort(nums);
			for(int i=0;i<x;i++) {
				sb.append(nums.get(i)+"\n");
			}
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}