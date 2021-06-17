import java.io.*;
public class B11720 {
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output=new BufferedWriter(new OutputStreamWriter(System.out));
		int x=Integer.parseInt(input.readLine());
		String[] array=input.readLine().split("");
		int sum=0;
		for(int i=0;i<x;i++)
			sum+=Integer.valueOf(array[i]);
		output.write(String.valueOf(sum));
		output.flush();
		output.close();
		input.close();
	}
}