#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int visited[100001];
vector<int> graph[100001];
vector<int> pa;
void dfs(int idx) {
    visited[idx] = 1;
    for(auto next: graph[idx]) {
        if(visited[next])
            pa[idx] = next;
        else {
            dfs(next);
        }
    }
}

int main() {
    int t;
    cin >> t;
    // graph.resize(t + 1, 0);
    pa.resize(t + 1, 0);
    for(int i = 0; i < t - 1; i++) {
        int s, e;
        cin >> s >> e;
        graph[s].push_back(e);
        graph[e].push_back(s);
    }
    dfs(1);
    for(int i = 2; i <= t; i++)
        cout << pa[i] << "\n";
}