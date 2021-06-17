#include<bits/stdc++.h>
using namespace std;
int n, answer;
int t[16], p[16];

void go(int idx, int values) {
    if(idx == n + 1) {
        answer = max(answer, values);
        return;
    }
    if(idx > n + 1) return;

    go(idx + t[idx], values + p[idx]);
    go(idx + 1, values);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> n;
    for(int i = 1; i <= n; i++) {
        cin >> t[i] >> p[i];
    }

    go(1, 0);
    cout << answer;
}