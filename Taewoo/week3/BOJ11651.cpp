#include<bits/stdc++.h>
using namespace std;

struct node {
    int x, y;

    bool operator <(const node &a) const {
        if(y == a.y) return x < a.x;
        else return y < a.y;
    }
};


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int n; cin >> n;
    vector<node> v;
    for(int i = 0; i < n; i++) {
        int x, y; cin >> x >> y;
        v.push_back({x, y});
    }

    sort(v.begin(), v.end());

    for(node i : v) cout << i.x << ' ' << i.y << '\n';
    return 0;
}