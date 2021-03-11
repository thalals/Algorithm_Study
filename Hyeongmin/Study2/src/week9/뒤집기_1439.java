package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class 뒤집기_1439 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split("");
		
		int one=0;
		int zero=0;
		
		
		String flag= s[0];
		
		if(flag.contains("1"))
			one++;
		else
			zero++;
		
		for(int i=0;i<s.length;i++) {
			//전에와 지금이 같으면
			if(flag.contains(s[i])) {
				continue;
			}
			//달라지면
			else {
				flag = s[i];
				if(flag.contains("1"))
					one++;
				else
					zero++;
			}
		}
		
		System.out.println(Math.min(one, zero));
		
	}

}
