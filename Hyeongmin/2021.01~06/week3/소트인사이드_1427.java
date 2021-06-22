package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class 소트인사이드_1427 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String temp[] = br.readLine().split("");
		
		ArrayList<Integer> arr = new ArrayList<Integer>();

		for(String a:temp)
			arr.add(Integer.parseInt(a));
		
		Collections.sort(arr);
		
		Collections.reverse(arr);
		
		for(int t : arr)
			bw.append(t+"");
		
		bw.close();
		br.close();
	}

}
