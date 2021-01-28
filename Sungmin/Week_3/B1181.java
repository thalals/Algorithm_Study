import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class B1181 {
	static class WordSort implements Comparable<WordSort>{
		int size;
		String s;
		boolean repeat;
		
		public WordSort(String s) {
			this.size=s.length();
			this.s=s;
			repeat=false;
		}
		
		@Override //-1이면 앞 거, 1이면 뒤 거
		public int compareTo(WordSort Word) {
			if(this.size<Word.size) return -1;
			else if(this.size==Word.size) {
				if(this.s.compareTo(Word.s)<0) return -1;
				else if(this.s.compareTo(Word.s)==0) {
					Word.repeat=true;
					return -1;
				}
			}
			return 1;
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			int count=Integer.parseInt(input.readLine());
			ArrayList<WordSort> array = new ArrayList<WordSort>();
			for(int i=0;i<count;i++) {
				WordSort temp = new WordSort(input.readLine());
				array.add(temp);
			}
			Collections.sort(array);
			for(int i=0;i<array.size();i++) {
				if(array.get(i).repeat) continue;
				sb.append(array.get(i).s+"\n");
			}
				
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}