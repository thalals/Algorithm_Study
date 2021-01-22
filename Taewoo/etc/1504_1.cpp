#include<bits/stdc++.h>
using namespace std;
int N, E;
const int INF = 1e9;
vector<pair<int, int>> graph[801];
long long dist[801][801];

void solve() {
    for(int k = 1; k <= N; k++) {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                dist[i][j] = min(dist[i][j], dist[i][k]+dist[k][j]);
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> N >> E;
    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= N; j++) {
            if(i == j) dist[i][j] = 0;
            else dist[i][j] = INF;
        }
    }    
    for(int t = 0; t < E; t++) {
        int a, b, c; cin >> a >> b >> c;
        dist[a][b] = c;
        dist[b][a] = c;
    }

    int v1, v2; cin >> v1 >> v2;
    solve();
    long long answer = min(dist[1][v1]+dist[v1][v2]+dist[v2][N], dist[1][v2]+dist[v2][v1]+dist[v1][N]);
    if(answer >= INF) cout << -1 <<'\n';
    else cout << answer;
}