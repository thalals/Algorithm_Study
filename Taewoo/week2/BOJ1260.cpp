// DFS와 BFS
#include<bits/stdc++.h>
using namespace std;
vector<int> graph[1001];
int visited[1001];

void dfs(int v){
	visited[v]=1;
	cout<<v<<' ';
	for(int next: graph[v]){
		if(!visited[next]) {
		dfs(next);
        }
	}
    return;
}


void bfs(int v){
    memset(visited, 0, sizeof(visited));
    queue<int> q;
    visited[v]=1;
    q.push(v);

    while(!q.empty()) {
        int x = q.front(); q.pop();
        cout<<x<<' ';
        for(int next:graph[x]){
            if(!visited[next]) {
                q.push(next);
                visited[next] = visited[x] + 1;
            }
        }
    }
}

int main() {
    int N, M, V; cin >> N >> M >>V;
    memset(visited, 0, sizeof(visited));

    for(int i = 0; i < M; i++){
        int a, b; cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }
    for(int i=1; i<=N; i++) sort(graph[i].begin(), graph[i].end());
    dfs(V);
    cout<<'\n';
    bfs(V);
    return 0;
}

