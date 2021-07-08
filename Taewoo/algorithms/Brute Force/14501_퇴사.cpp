#include <bits/stdc++.h>
using namespace std;

int t[15], p[15];
int n;
void input() {
    cin >> n;
    for(int i = 0; i < n; i++)
        cin >> t[i] >> p[i];
    
}

int answer;
void go(int idx, int values) {
    if(idx == n) {
        answer = max(answer, values);
        return;
    }
    if(idx > n) return;

    go(idx + 1, values);
    go(idx + t[idx], values + p[idx]);
}

void pro() {
    go(0, 0);
    cout << answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}