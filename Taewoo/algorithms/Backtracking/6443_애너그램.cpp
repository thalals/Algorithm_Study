#include <bits/stdc++.h>
using namespace std;

int n;
vector<string> v;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    v.resize(n);
    for(int i = 0; i < n; i++) cin >> v[i];

    for(int i = 0; i < v.size(); i++) {
        sort(v[i].begin(), v[i].end());
        do {
            cout << v[i] << '\n';
        } while(next_permutation(v[i].begin(), v[i].end()));
    }
}  