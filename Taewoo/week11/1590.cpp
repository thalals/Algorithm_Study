#include<bits/stdc++.h>
using namespace std;

vector<int> blist[100001];
int n, t;
int answer = 2e9;
void input() {
    cin >> n >> t;
    for(int i = 0; i < n; i++) {
        int start_time, gap_time, count;
        cin >> start_time >> gap_time >> count;
        blist[i].push_back(start_time);
        for(int j = 0; j < count - 1; j++) {
            blist[i].push_back(start_time += gap_time);
        }
    }
}

void pro() {
    for(int i = 0; i < n; i++) {
        int values =  *lower_bound(blist[i].begin(), blist[i].end(), t);
        if(values >= t) {
            answer = min(answer, values - t);
        }
    }
    if(answer == 2e9) cout << -1;
    else cout << answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    input();
    pro();
    return 0;
}