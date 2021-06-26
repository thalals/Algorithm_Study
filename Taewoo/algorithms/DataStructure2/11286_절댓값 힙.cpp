#include <bits/stdc++.h>
using namespace std;

int n;
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>> > pq;
void input() {
    cin >> n;
}

void pro() {
    while(n--) {
        int num;
        cin >> num;
        if(num == 0) {
            if(pq.empty()) cout << 0 << '\n';
            else {
                cout << pq.top().second << '\n';
                pq.pop();
            }
        }
        else {
            pq.push({abs(num), num});
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}