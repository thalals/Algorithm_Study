#include<bits/stdc++.h>

using namespace std;

struct meeting {
    int start, finish;

    bool operator < (const meeting &e){
        if(finish == e.finish) return start < e.start;
        else return finish < e.finish;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N; cin >> N;
    vector<meeting> t(N);
    for(int i = 0; i < N; i++) {
        cin >> t[i].start >> t[i].finish;
    }

    sort(t.begin(), t.end());
    
    int now = t[0].finish;
    int count = 1;
    for(int i = 1; i < N; i++) {
        if(now <= t[i].start) {
            count++;
            now = t[i].finish;
        }
    }
    cout << count;
}