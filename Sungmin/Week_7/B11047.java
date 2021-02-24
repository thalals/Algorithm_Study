import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11047 {
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			String[] s = input.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int value=Integer.parseInt(s[1]);
			int coincount=0;
			int index=0;
			int[] coin=new int[n];
			for(int i=0;i<n;i++) coin[i]=Integer.parseInt(input.readLine());
			for(int i=0;i<n;i++) {
				if(i==0)continue;
				else if(i==n-1) {
					index=i;
					break;
				}
				else if(coin[i-1]<=value&&value<coin[i]) {
					index=i-1;
					break;
				}
			}
			while(0!=value) {
				coincount=coincount+(value/coin[index]);
				value%=coin[index];
				index--;
			}
			System.out.print(coincount);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}