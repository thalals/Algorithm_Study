#include <bits/stdc++.h>
using namespace std;

int n, m;
int check[201][201];
void input() {
    cin >> n >> m;
    for(int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        check[a][b] = 1;
        check[b][a] = 1;
    }
}

int selected[200];
int answer;

void dfs(int cnt) {
    if(cnt == 4) {
        if(check[selected[1]][selected[2]] || check[selected[2]][selected[3]] || check[selected[1]][selected[3]]) return;
        else answer++;
        return;
    }

    for(int i = selected[cnt - 1] + 1; i <= n; i++) {
        selected[cnt] = i;
        dfs(cnt + 1);
        selected[cnt] = 0;
    }
}

void pro() {
    dfs(1);
    cout << answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}