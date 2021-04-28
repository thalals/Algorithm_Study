/*
Comment : 
*/

#include<bits/stdc++.h>
using namespace std;
int a, b;
int n, m;
vector<int> v[1001];
int visited[1001];

void input() {
    cin >> a >> b;
    cin >> n >> m;
    fill(visited, visited + 1001, -1);
    for(int i = 0; i < m; i++) {
        int x, y; cin >> x >> y;
        v[x].push_back(y);
        v[y].push_back(x);
    }
}

void bfs() {
    queue<int> q;
    q.push(a);
    visited[a] = 0;
    while(!q.empty()) {
        int here = q.front();
        q.pop();
        if(here == b) {
            cout << visited[here];
            return;
        }
        for(int next : v[here]) {
            if(visited[next] == -1) {
                q.push(next);
                visited[next] = visited[here] + 1;
            }
        }
    }
    cout << -1;
}

int main() {
    input();
    bfs();
}