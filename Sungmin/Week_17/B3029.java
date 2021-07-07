import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3029 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String s1=input.readLine();
		String[] s11=s1.split(":");
		int[] current=new int[3];
		for(int i=0;i<3;i++)
			current[i]=Integer.parseInt(s11[i]);
		String s2=input.readLine();
		String[] s22=s2.split(":");
		int[] obj=new int[3];
		String[] result=new String[3];
		for(int i=0;i<3;i++)
			obj[i]=Integer.parseInt(s22[i]);
		if(s1.equals(s2)) {
			result[0]="24";result[1]="00";result[2]="00";
		}
		else {
			if(obj[2]<current[2]) {
				obj[2]+=60;obj[1]-=1;
			}
			int second=obj[2]-current[2];
			if(second<10)result[2]="0"+String.valueOf(second);
			else result[2]=String.valueOf(second);
			if(obj[1]<current[1]) {
				obj[1]+=60; obj[0]-=1;
			}
			int min=obj[1]-current[1];
			if(min<10)result[1]="0"+String.valueOf(min);
			else result[1]=String.valueOf(min);
			if(obj[0]<current[0]) obj[0]+=24;
			int hour=obj[0]-current[0];
			if(hour<10)result[0]="0"+String.valueOf(hour);
			else result[0]=String.valueOf(hour);
		}
		System.out.print(result[0]+":"+result[1]+":"+result[2]);
		input.close();
	}
}
