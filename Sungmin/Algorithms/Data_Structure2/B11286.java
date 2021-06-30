import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B11286 {
	static class num implements Comparable<num>{
		int x;
		num(int x){
			this.x=x;
		}
		@Override
		public int compareTo(num Word) {
			if(Math.abs(this.x)<Math.abs(Word.x))return -1;
			else if(Math.abs(this.x)==Math.abs(Word.x)) {
				if(this.x<Word.x) return -1;
				else if(this.x==Word.x) return 0;
			}
			return 1;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<num> queue = new PriorityQueue<num>();
		StringBuilder sb=new StringBuilder();
		int n=Integer.parseInt(input.readLine());
		for(int i=0;i<n;i++) {
			int x=Integer.parseInt(input.readLine());
			if(x==0) {//상위 출력 및 제거
				if(queue.isEmpty()) sb.append("0"+"\n");
				else sb.append(queue.poll().x+"\n");
			}
			else {
				queue.add(new num(x));
			}
		}
		System.out.print(sb);
		input.close();
	}
}
