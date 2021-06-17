#include<bits/stdc++.h>
using namespace std;

int N, M;
int graph[9][9];
int answer;
int dx[4] = {0, 0, -1, 1};
int dy[4] = {1, -1, 0, 0};
int visited[9][9];
vector<pair<int,int>> candid;
vector<int> wall;

void dfs(int x, int y) {
    visited[x][y] = 1;
    
    for(int i = 0; i < 4; i++) {
        int X = x + dx[i];
        int Y = y + dy[i];

        if(X < 0 || X == N || Y < 0 || Y == M || visited[X][Y]) continue;
        if(graph[X][Y] == 0){
            dfs(X, Y);
        }
    }
}

void spread() {
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            if(graph[i][j] == 2 && !visited[i][j]) {
                dfs(i, j);
            }
        }
    }
    int count = 0;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            if(graph[i][j] == 0 && visited[i][j] == 0) {
                count++;
            } 
        }
    }
    answer = max(answer, count);
}

void make_wall() {
    int x, y;
    for(auto i: wall) {
        x = candid[i].first;
        y = candid[i].second;
        graph[x][y] = 1;
    }

    fill(&visited[0][0], &visited[0][0] + 9 * 9, 0);
    spread();

    for(auto i: wall) {
        x = candid[i].first;
        y = candid[i].second;
        graph[x][y] = 0;
    }
}

void find_wall() {
    if(wall.size() == 3) {
        make_wall();
        return;
    }
    
    int back = wall.empty() ? -1 : wall.back();
    for(int i = back + 1; i < candid.size(); i++) {
        wall.push_back(i);
        find_wall();
        wall.pop_back();
    }
}

void solve(){
    find_wall();
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M;    
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++){
            cin >> graph[i][j];
            if(graph[i][j] == 0) candid.push_back({i, j});
        }
    }
    solve();
    cout << answer << '\n';
}