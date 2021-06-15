#include<bits/stdc++.h>
using namespace std;

int w[11][11];
int visited[11];
int n, answer = 1e9;

void init() {
    cin >> n;
    for(int i = 1; i<= n; i++)
        for(int j = 1; j <= n; j++)
            cin >> w[i][j];
}

void dfs(int here, int count, int values, int start) {
    if(count == n) {
        if(w[here][start]) {
            answer = min(answer, values + w[here][start]);
            return;
        }
    }

    for(int next = 1; next <= n; next++) {
        if(!visited[next] && w[here][next]) {
            // 들릴 수 있고 다음 점을 갈 수 있다면
            visited[next] = 1;
            dfs(next, count + 1, values + w[here][next], start);
            visited[next] = 0;
        }
    }
}

void solution() {
    init();
    for(int i = 1; i <= n; i++) {
        int start = i;
        visited[start] = 1;
        dfs(start, 1, 0, start);
        visited[start] = 0;
    }
    cout << answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    solution();    
}