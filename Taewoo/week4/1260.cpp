#include<iostream>
#include<vector>
#include<queue>
#include<cstring>
#include<algorithm>
using namespace std;

vector<int> graph[1001];
bool visited[1001];

void dfs(int here) {
    visited[here] = true;
    cout << here << ' ';
    for(int i = 0; i < graph[here].size(); i++) {
        int next = graph[here][i];
        if(visited[next] == true) continue;
        else if(visited[next] == false) dfs(next); 
    }
}
void bfs(int here) {
    memset(visited, 0, sizeof(visited));
    queue<int> q;
    q.push(here);
    visited[here] = true;

    while(!q.empty()) {
        int x = q.front();
        q.pop();
        
        cout << x << ' ';
        for(int i = 0; i < graph[x].size(); i++) {
            int next = graph[x][i];
            if(visited[next] == true) continue;
            else if(visited[next] == false) {
                q.push(next);
                visited[next] = true;
            }
        }
    }   
}

int main () {
    int N, M, V;
    cin >> N >> M >> V;

    for(int i = 0; i < M; i++) {
        int x, y;
        cin >> x >> y;
        graph[x].push_back(y);
        graph[y].push_back(x);
    }

    for(int i = 1; i <= N; i++)
        sort(graph[i].begin(), graph[i].end());

    dfs(V);
    cout << '\n';
    bfs(V);
}