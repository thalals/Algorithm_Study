#include<bits/stdc++.h>
using namespace std;
int N, E;
const int INF = 1e9;
vector<pair<int, int>> graph[801];
vector<long long> dist;
vector<long long> dist_v1;
vector<long long> dist_v2;
void solve(vector<long long> &dist, int start) {
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    dist = vector<long long> (N + 1, INF);
    dist[start] = 0;
    pq.push({0, start});

    while(!pq.empty()) {
        pair<int, int> p = pq.top(); pq.pop();
        if(dist[p.second] < p.first) continue;

        for(auto next : graph[p.second]) {
            if(dist[next.second] > dist[p.second] + next.first) {
                dist[next.second] = dist[p.second] + next.first;
                pq.push({dist[next.second], next.second});
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    
    cin >> N >> E;
    for(int i = 0; i < E; i++) {
        int a, b, c; cin >> a >> b >> c;
        graph[a].push_back({c, b});
        graph[b].push_back({c, a});
    }
    int v1, v2; cin >> v1 >> v2;
    
    solve(dist, 1);
    solve(dist_v1, v1);
    solve(dist_v2, v2);

    if(dist[v1] + dist_v1[v2] + dist_v2[N] >= INF && dist[v2] + dist_v2[v1] + dist_v1[N] >= INF) cout << -1 << '\n';
    else cout << min(dist[v1] + dist_v1[v2] + dist_v2[N], dist[v2] + dist_v2[v1] + dist_v1[N]);
}