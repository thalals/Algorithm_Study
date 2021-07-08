/*
 * 해시를 사용한 접근. 파이썬 딕셔너리 형태라 생각하면 이해하기 쉽다
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class B1620 {
	static class PokeHash implements Comparable<PokeHash>{
		int index;
		String pokemon;
		
		PokeHash(String pokemon, int index){
			this.index=index;
			this.pokemon=pokemon;
		}
		@Override
		public int compareTo(PokeHash Word) {
			if(this.pokemon.compareTo(Word.pokemon)>0)return 1;
			else if(this.pokemon.compareTo(Word.pokemon)<0)return -1;
			return 0;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String[] s =input.readLine().split(" ");
		int pokenum=Integer.parseInt(s[0]);
		int riddle=Integer.parseInt(s[1]);
		PokeHash[] pokemon=new PokeHash[pokenum];
		String[] pokemonsort=new String[pokenum];
		for(int i=0;i<pokenum;i++) {
			String temp=input.readLine();
			pokemon[i]=new PokeHash(temp,i);
			pokemonsort[i]=pokemon[i].pokemon;
		}
		Arrays.sort(pokemon);
		for(int i=0;i<riddle;i++) {
			String temp=input.readLine();
			if(temp.charAt(0)>='0'&&temp.charAt(0)<='9')
				sb.append(pokemonsort[Integer.parseInt(temp)-1]+"\n");
			else {
				int low,high;
				int mid;
				low=0;
				high=pokenum-1;
				while(low<=high) {
					mid=(low+high)/2;
					if(pokemon[mid].pokemon.compareTo(temp)==0) {
						sb.append(((pokemon[mid].index)+1)+"\n");
						break;
					}
					else if(pokemon[mid].pokemon.compareTo(temp)>0)
						high=mid-1;
					else if(pokemon[mid].pokemon.compareTo(temp)<0)
						low=mid+1;
				}
			}
		}
		System.out.print(sb);
		input.close();
	}
}