#include <bits/stdc++.h>
using namespace std;

int n, m;
set<string> s;
string str;
void input() {
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        cin >> str;
        s.insert(str);
    }
}

int cnt;
void pro() {
    for(int i = 0; i < m; i++) {
        cin >> str;
        if(s.count(str)) cnt++;
    }
    cout << cnt;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}