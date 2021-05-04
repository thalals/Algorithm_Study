import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B20154 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb=new StringBuilder();
		int[] temparray= {3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};
		String s=input.readLine();
		int length=s.length();
		int[] array=new int[s.length()+1];
		for(int i=1;i<=s.length();i++)
			array[i]=temparray[s.charAt(i-1)-65];
		int standard=s.length()/2;
		while(true) {
			if(standard==0)break;
			for(int i=1;i<=standard;i++)
				array[i]=(array[i*2-1]+array[i*2])%10;
			if(length%2==1) {//È¦¼ö
				array[standard+1]=array[length];
				length=length/2+1;
			}
			else
				length/=2;
			standard=length/2;
		}
		if(array[1]%2==1)
			System.out.print("I'm a winner!");
		else
			System.out.print("You're the winner?");
		input.close();
	}
}