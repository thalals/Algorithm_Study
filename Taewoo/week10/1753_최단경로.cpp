/*
Comment : 우선순위 큐 default는 최대힙
          구조체로 할 땐 operator 지정 잘하자..
          아니면 priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int,int>>> pq로 ....
          priority_queue<pair<int,int>> 로 하면 default가 최대힙이라 less로 설정된다..
          다익스트라는 최단거리를 뽑을 때 거리가 가장 짧은 것을 뽑아야 하기에 최소힙으로 바꾸자..
*/
#include <bits/stdc++.h>
using namespace std;

struct edge {
    int to;
    int dist;
    bool operator < (const edge &e) const&{
        return dist > e.dist;
    }
};   
const int INF = 1e9;
int V, E, K;
vector<edge> graph[20001];
vector<int> dist;
priority_queue<edge> pq;

void dijkstra(int start) {
    dist[start] = 0;
    pq.push({start, 0});

    while(!pq.empty()) {
        edge e = pq.top();
        pq.pop();
        if(e.dist > dist[e.to]) continue;

        for(edge next : graph[e.to]) {
            if(dist[next.to] > dist[e.to] + next.dist) {
                dist[next.to] = dist[e.to] + next.dist;
                pq.push({next.to, dist[next.to]});
            }
        }
    }
}

int main() {
    cin >> V >> E >> K;
    dist = vector<int> (V + 1, INF);
    for(int i = 0; i < E; i++) {
        int u, v, len;
        cin >> u >> v >> len;
        graph[u].push_back({v, len});
    }
    dijkstra(K);
    for(int i = 1; i <= V; i++) {
        if(dist[i] == INF) cout << "INF" << '\n';
        else cout << dist[i] << '\n';
    }
}