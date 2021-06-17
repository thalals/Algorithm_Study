#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

bool compare(const pair<int, int> &a, const pair<int, int> &b) {
    return a.second < b.second;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n; cin >> n;
    vector<pair<int, int> > vec(n);
    for(int i = 0; i < n; i++) {
        int a, b; cin >> a >> b;
        vec[i] = make_pair(a, b);
    }
    sort(vec.begin(), vec.end());
    int x = vec[(n-1) / 2].first;
    sort(vec.begin(), vec.end(), compare);
    int y = vec[(n-1) / 2].second;

    long long answer = 0;
    for(int i = 0; i < n; i++) {
        answer += abs(x - vec[i].first) + abs(y - vec[i].second);
    }
    cout << answer;
}