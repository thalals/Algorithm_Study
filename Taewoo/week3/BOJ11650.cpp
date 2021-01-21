#include<bits/stdc++.h>
using namespace std;
struct node {
    int x, y;

    bool operator <(const node &a) const{
        if(x == a.x) return y < a.y;
        else return x < a.x;
    }
};
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int N; cin >> N;
    vector<node> v;
    for(int i = 0; i < N; i++) {
        int a, b; cin >> a >> b;
        v.push_back({a,b});
    }
    sort(v.begin(), v.end());

    for(auto i: v) cout << i.x << ' ' << i.y << '\n';
}