#include<bits/stdc++.h>

using namespace std;

struct meeting {
    int begin, end;

    bool operator < (const meeting &e) const &{
        if(end == e.end) return begin < e.begin;
        else return end < e.end;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N; cin >> N;
    vector<meeting> t(N);
    for(int i = 0; i < N; i++) {
        cin >> t[i].begin >> t[i].end;
    }

    sort(t.begin(), t.end());
    
    int now = t[0].end;
    int count = 1;
    for(int i = 1; i < N; i++) {
        if(now <= t[i].begin) {
            count++;
            now = t[i].end;
        }
    }
    cout << count;
}