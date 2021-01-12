import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class B10845 {
	public static void main(String[] args) {
		try {
			int back = 0;
			Queue<Integer> array = new LinkedList<>();
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			int x=Integer.parseInt(input.readLine());
			for(int i=0;i<x;i++) {
				String[] command = input.readLine().split(" ");
				if(command[0].equals("push")) {
					back=Integer.valueOf(command[1]);
					array.add(back);
				}
				else if(command[0].equals("pop")) {
					if(array.size()==0)sb.append("-1\n");
					else sb.append(String.valueOf(array.poll())+"\n");
				}
				else if(command[0].equals("size")) sb.append(String.valueOf(array.size())+"\n");
				else if(command[0].equals("empty")) {
					if(array.size()==0)sb.append("1\n");
					else sb.append("0\n");
				}
				else if(command[0].equals("front")) {
					if(array.size()==0)sb.append("-1\n");
					else sb.append(String.valueOf(array.peek())+"\n");
				}
				else if(command[0].equals("back")) {
					if(array.size()==0)sb.append("-1\n");
					else sb.append(back+"\n");
				}
			}
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}