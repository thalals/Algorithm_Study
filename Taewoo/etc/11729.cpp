#include<bits/stdc++.h>
using namespace std;
vector<pair<int, int>> v;
void solve(int num, int from, int by, int to) {
    if(num == 1) v.push_back({from, to});
    else {
        solve(num - 1, from, to, by);
        v.push_back({from, to});
        solve(num - 1, by, from, to);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int n; cin >> n;
    solve(n, 1, 2, 3);
    cout << v.size() << '\n';
    for(pair<int, int> i : v)
        cout << i.first << ' ' << i.second << '\n';
}