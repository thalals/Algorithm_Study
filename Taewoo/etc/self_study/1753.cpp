#include<bits/stdc++.h>
using namespace std;

struct edge {
    int to;
    int dist;

    bool operator <(const edge &e) const{
        return dist > e.dist;
    }
};
const int INF = 1e9;
int V, E, K;
vector<edge> graph[20001];
vector<int> dist;
priority_queue<edge> pq;

void solve(int start) {
    dist[start] = 0;
    pq.push({start, 0});

    while(!pq.empty()) {
        edge e = pq.top(); pq.pop();
        for(edge next : graph[e.to]) {
            if(dist[next.to] > next.dist + dist[e.to]) {
                dist[next.to] = next.dist + dist[e.to];
                pq.push({next.to, dist[next.to]});
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> V >> E >> K;
    for(int i = 0; i < E; i++){
        int u, v, w;
        cin >> u >> v >> w;
        graph[u].push_back({v, w});
    }
    dist = vector<int> (V+1, INF);
    solve(K);

    for(int i = 1; i <= V; i++) {
        if(dist[i] == INF) cout << "INF" << '\n';
        else cout << dist[i] << '\n';
    }
}