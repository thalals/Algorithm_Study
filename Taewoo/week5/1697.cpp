#include<bits/stdc++.h>
using namespace std;

int N, K;
int visited[100001];
int dx[3];
int bfs(int start) {
    queue<int> q;
    q.push(start);
    memset(visited, -1, sizeof(visited));
    visited[start] = 0;
    
    while(!q.empty()) {
        int x = q.front();
        q.pop();

        dx[0] = x + 1; dx[1] = x - 1; dx[2] = x * 2;
        for(int i = 0; i < 3; i++) {
            int next = dx[i];
            if(next < 0 || next >= 100001 || visited[next] != -1) continue;
            visited[next] = visited[x] + 1;
            q.push(next);
        }
    }
    return visited[K];
}
int main () {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N >> K;
    cout << bfs(N);
    
}