#include<bits/stdc++.h>
using namespace std;
int graph[26][26];
int visited[26][26];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int N;
vector<int> component;
void dfs(int x, int y, int idx) {
    visited[x][y] = 1;
    component[idx]++;
    for(int i = 0; i < 4; i++) {
        int X = x + dx[i];
        int Y = y + dy[i];
        if(X < 0 || X == N || Y < 0 || Y == N) continue;
        if(!visited[X][Y] && graph[X][Y]) {
            dfs(X, Y, idx);
        }
    }
}

int main() {
    cin >> N;
    for(int i = 0; i < N; i++)
        for(int j = 0; j < N; j++)
            scanf("%1d", &graph[i][j]);
    
    for(int i = 0; i < N; i++) {
        for(int j =0; j < N; j++) {
            if(!visited[i][j] && graph[i][j]) {
                component.push_back(0);
                dfs(i, j, component.size() - 1);
            }
        }
    }    
    cout << component.size() << '\n';
    sort(component.begin(), component.end());
    for(int i : component)
        cout << i << '\n';
}