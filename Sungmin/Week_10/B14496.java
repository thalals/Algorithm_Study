import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
public class B14496 {
	static int INF=1000000000;
	public static void main(String[] args) {
		class DijkstraQueue implements Comparable<DijkstraQueue>{
			int index;
			int dist;
			DijkstraQueue(int index, int dist){
				this.index=index;
				this.dist=dist;
			}
			
			@Override
			public int compareTo(DijkstraQueue Word) {
				if(this.dist<Word.dist)return -1;
				else if(this.dist>Word.dist)return 1;
				return 0;
			}
		}
		try {
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb=new StringBuilder();
			PriorityQueue<DijkstraQueue> pQueue=new PriorityQueue<DijkstraQueue>();
			
			String[] s = input.readLine().split(" ");
			int start=Integer.parseInt(s[0]);
			int end=Integer.parseInt(s[1]);
			
			s=input.readLine().split(" ");
			int vertex=Integer.parseInt(s[0]);
			int edge=Integer.parseInt(s[1]);
			
			int[] dist=new int[vertex+1];
			for(int i=1;i<=vertex;i++) {
				if(i==start) {
					pQueue.add(new DijkstraQueue(i,0));
					dist[i]=0;
				}
				else{
					pQueue.add(new DijkstraQueue(i,INF));
					dist[i]=INF;
				}
			}
			
			boolean[] visited=new boolean[vertex+1];
			int[][] array=new int[vertex+1][vertex+1];
			for(int i=1;i<=vertex;i++) {
				for(int i1=1;i1<=vertex;i1++) {
					if(i==i1)continue;
					array[i][i1]=INF;
				}
			}
			
			for(int i=1;i<=edge;i++) {
				s=input.readLine().split(" ");
				int x=Integer.parseInt(s[0]);
				int y=Integer.parseInt(s[1]);
				array[x][y]=1;
				array[y][x]=1;
			}
			
			while(!pQueue.isEmpty()) {
				DijkstraQueue temp=pQueue.poll();
				if(temp.dist==INF)break;
				visited[temp.index]=true;
				for(int i=1;i<=vertex;i++) {
					if(array[temp.index][i]!=0) {
						if(dist[i]>dist[temp.index]+array[temp.index][i]) {
							dist[i]=dist[temp.index]+array[temp.index][i];
							pQueue.add(new DijkstraQueue(i,dist[i]));
						}
					}
				}
			}
			if(dist[end]==INF) sb.append("-1");
			else sb.append(dist[end]);
			System.out.print(sb);
			input.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}