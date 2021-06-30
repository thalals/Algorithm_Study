#include <bits/stdc++.h>
using namespace std;

int n, m;
map<int, string> mp;
map<string, int> reverse_mp;
string s;
void input() {
    cin >> n >> m;
    for(int i = 1; i <= n; i++) {
        cin >> s;
        mp[i] = s;
        reverse_mp[s] = i;
    }
}

string tmp;
void pro() {
    for(int i = 1; i <= m; i++) {
        cin >> tmp;
        if(atoi(tmp.c_str()) == 0) {
            cout << reverse_mp[tmp] << '\n';
        }
        else cout << mp[atoi(tmp.c_str())] << '\n';
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}