#include<bits/stdc++.h>
using namespace std;

vector<int> graph[101];
int visited[101];

int solution(int start) {
    int count = 0;
    queue<int> q;
    q.push(start);
    visited[start] = 0;

    while(!q.empty()) {
        int x = q.front(); q.pop();
        
        for(int next : graph[x]) {
            if(visited[next] != -1) continue;
            q.push(next);
            visited[next] = visited[x] + 1;
            count++;
        }
    }
    return count;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M; cin >> N >> M;
    
    memset(visited, -1, sizeof(visited));
    for(int i = 0; i < M; i++) {
        int x, y; cin >> x >> y;
        graph[x].push_back(y);
        graph[y].push_back(x);
    }

    cout << solution(1);
}