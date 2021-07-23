#include<bits/stdc++.h>
using namespace std;

int N, M;
int graph[501][501];
void input() {
    cin >> N >> M;
    for(int i = 0; i < N; i++)
        for(int j = 0; j < M; j++)
            cin >> graph[i][j];
}

void go(int x, int y) {
    
}

void pro() {
    go(0, 0);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}