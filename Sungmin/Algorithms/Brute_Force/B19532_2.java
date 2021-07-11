/*
 * 가감식은 왜 안 되는거지
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class B19532_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(input.readLine());
		float[] arrays=new float[6];
		for(int i=0;i<6;i++) arrays[i]=Float.parseFloat(stk.nextToken());
		float x,y;
		if(arrays[0]==0||arrays[3]==0) {
			x=0;
			if(arrays[1]==0||arrays[4]==0)
				y=0;
			else
				y=(arrays[2]+arrays[5])/(arrays[1]+arrays[4]);
		}
		else if(arrays[1]==0||arrays[4]==0) {
			y=0;
			x=(arrays[2]+arrays[5])/(arrays[0]+arrays[3]);
		}
		else {
			if(arrays[0]>arrays[3]) {
				float times=arrays[0]/arrays[3];
				for(int i=3;i<6;i++)
					arrays[i]*=times;
			}
			else if(arrays[0]<arrays[3]){
				float times=arrays[3]/arrays[0];
				for(int i=0;i<3;i++)
					arrays[i]*=times;
			}
			float newY=arrays[1]-arrays[4];
			y=(arrays[2]-arrays[5])/newY;
			x=(arrays[2]-(arrays[1]*y))/arrays[0];
		}
		System.out.print((int)x+" "+(int)y);
		input.close();
	}
}