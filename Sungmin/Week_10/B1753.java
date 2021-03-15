import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
public class B1753 {
	static int INF=1000000000;
	static class DijkstraQueue implements Comparable<DijkstraQueue>{
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		String[] s=input.readLine().split(" ");
		int vertex=Integer.parseInt(s[0]);
		int edge=Integer.parseInt(s[1]);
		int start=Integer.parseInt(input.readLine());
		ArrayList<ArrayList<DijkstraQueue>> newArray=new ArrayList<ArrayList<DijkstraQueue>>();
		PriorityQueue<DijkstraQueue> pQueue=new PriorityQueue<DijkstraQueue>();
		
		boolean[] visited=new boolean[vertex+1];
		for(int i=0;i<=vertex;i++)
			newArray.add(new ArrayList<DijkstraQueue>());
			
		for(int i=1;i<=edge;i++) {
			s=input.readLine().split(" ");
			int x=Integer.parseInt(s[0]);
			int y=Integer.parseInt(s[1]);
			int w=Integer.parseInt(s[2]);
			newArray.get(x).add(new DijkstraQueue(y,w));
		}
		
		int[] dist=new int[vertex+1];
		for(int i=1;i<=vertex;i++) {
			if(i==start) dist[i]=0;
			else dist[i]=INF;
			pQueue.add(new DijkstraQueue(i,dist[i]));
		}
			
		while(!pQueue.isEmpty()) {
			DijkstraQueue temp=pQueue.poll();
			if(temp.dist==INF)break;
			visited[temp.index]=true;
			for(int i=0;i<newArray.get(temp.index).size();i++) {
				int tempindex=newArray.get(temp.index).get(i).index;
				int tempdist=newArray.get(temp.index).get(i).dist;
				if(dist[tempindex]>dist[temp.index]+tempdist) {
					dist[tempindex]=dist[temp.index]+tempdist;
					if(!visited[tempindex])
						pQueue.add(new DijkstraQueue(tempindex,dist[tempindex]));
				}
			}
		}
		for(int i=1;i<=vertex;i++) {
			if(dist[i]==INF) sb.append("INF"+"\n");
			else sb.append(dist[i]+"\n");
		}
		System.out.print(sb);
		input.close();
	}
}