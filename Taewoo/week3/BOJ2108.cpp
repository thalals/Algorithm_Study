#include<bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    
    int n; cin >> n;
    int maxvalue = -4000;
    int minvalue = 4000;
    double ret = 0;
    vector<int> values(n);

    for(int i = 0; i < n; i++) {
        cin >> values[i];
        ret += values[i];
        maxvalue = max(maxvalue, values[i]);
        minvalue = min(minvalue, values[i]);
    }
    cout << (int)round(ret / double(n)) << '\n';

    int maxpos = 0;
    vector<int> cnt(8001, 0);
    for(int i = 0; i < n; i++) {
        int pos = values[i] + 4000;
        cnt[pos]++;
        maxpos = max(maxpos, cnt[pos]);
    }

    int count = 0;
    int secondMany = 0;
    for(int i = 0; i < cnt.size(); i++) {
        if(cnt[i] == maxpos) {
            count++;
            secondMany = i - 4000;
        }
        if(count == 2) {
            secondMany = i - 4000;
            break;
        }
    }

    sort(values.begin(), values.end());
    int mid = n/2;
    
    cout << values[mid] << '\n';
    cout << secondMany << '\n';
    cout << maxvalue - minvalue << '\n';
    return 0;
}