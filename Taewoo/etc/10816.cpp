#include <bits/stdc++.h>
using namespace std;
vector<int> vec;

void countingNumber(int num) {
    int count = 0;
    count = upper_bound(vec.begin(), vec.end(), num) - lower_bound(vec.begin(), vec.end(), num);
    cout << count << ' ';
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int n; cin >> n;
    for(int i = 0; i < n; i++) {
        int num; cin >> num;
        vec.push_back(num);
    }
    sort(vec.begin(), vec.end());

    int m; cin >> m;
    for(int i = 0; i < m; i++) {
        int num; cin >> num;
        countingNumber(num);
    }
}