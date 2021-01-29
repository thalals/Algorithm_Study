#include <bits/stdc++.h>
using namespace std;

int N, M;
vector<int> vec;
vector<int> subsum;
int main () {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> N >> M;
    for(int i = 0; i < N; i++) {
        int tmp; cin >> tmp;
        vec.push_back(tmp);
    }

    subsum.push_back(0);
    for(int i = 0; i < N; i++) {
        subsum.push_back(subsum[i]+vec[i]);
    }
    
    for(int i = 0; i < M; i++) {
        int a, b; cin >> a >> b;
        cout << subsum[b] - subsum[a-1] << '\n';
    }
}