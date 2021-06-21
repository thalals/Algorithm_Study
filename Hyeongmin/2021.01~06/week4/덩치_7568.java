package week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class person{
	int kg;
	int cm;
	
	person(){
		
	}
	person(int x, int y){
		kg = x;
		cm = y;
	}
}
public class µ¢Ä¡_7568 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		person a[] = new person[n];
		
		for(int i=0;i<n;i++) {
			String t[] = br.readLine().split(" ");
			person tp = new person(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
			
			a[i]  = tp;
		}
		
		for(int i=0;i<n;i++) {
			int count=0;
			for(int j=0;j<n;j++) {
				if(a[i].cm < a[j].cm && a[i].kg <a[j].kg)
					count++;
			}
			bw.append(count+1+" ");
		}
		
		bw.close();
		br.close();
	}

}
