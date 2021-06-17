/*
 * LinkedList를 이용한 단순 큐의 구현
 * 삭제가 빈번하게 일어나기 때문에 LinkedList 사용이 더 유리하다고 판단
 * back의 경우 탐색에 가장 많은 시간이 걸릴 것 같아 push할 때마다 새로운 변수를 만들어 초기화
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class B18258 {
	public static void main(String[] args) throws IOException{
		Queue<Integer> array = new LinkedList<>();
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x=Integer.parseInt(input.readLine());
		int back=-1;
		for(int i=0;i<x;i++) {
			String[] s = input.readLine().split(" ");
			if(s[0].equals("push")) {
				back=Integer.parseInt(s[1]);
				array.add(back);
			}
			else if(s[0].equals("pop")) {
				if(array.size()==0) sb.append("-1\n");
				else sb.append(array.poll()+"\n");
			}
			else if(s[0].equals("size"))
				sb.append(array.size()+"\n");
			else if(s[0].equals("empty")) {
				if(array.size()==0) sb.append("1\n");
				else sb.append("0\n");
			}
			else if(s[0].equals("front")) {
				if(array.size()==0) sb.append("-1\n");
				else sb.append(array.peek()+"\n");
			}
			else {
				if(array.size()==0) sb.append("-1\n");
				else sb.append(back+"\n");
			}
		}
		System.out.print(sb);
		input.close();
	}
}