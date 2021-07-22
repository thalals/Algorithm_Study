#include <bits/stdc++.h>
using namespace std;

int w[11][11];
int used[11];
int n, answer = 2e9;

void go(int here, int count, int values, int start) {
    if(count == n) {
        if(w[here][start]) {
            answer = min(answer, values + w[here][start]);
            return;
        }
    }
    for(int next = 1; next <= n; next++) {
        if(!used[next] and w[here][next]) {
            used[next] = 1;
            go(next, count + 1, values + w[here][next], start);
            used[next] = 0;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    for(int i = 1; i <= n; i++) for(int j = 1; j <= n; j++) cin >> w[i][j];

    for(int start = 1; start <= n; start++) {
        used[start] = 1;
        go(start, 1, 0, start);
        used[start] = 0;
    }
    cout << answer;
}