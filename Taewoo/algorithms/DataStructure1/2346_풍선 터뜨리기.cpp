/*
Problem : https://www.acmicpc.net/problem/2346
Comment : 양쪽에서 넣고 빼고 하기 위해서 덱이용!
*/
#include <bits/stdc++.h>
using namespace std;

int N;
deque<pair<int, int> > dq;
void input() {
    cin >> N;
    for(int i = 1; i <= N; i++) {
        int num;
        cin >> num;
        dq.push_back({i, num});
    }
}

void pro() {
    while(!dq.empty()) {
        int idx = dq.front().first;
        int val = dq.front().second;
        cout << idx << ' ';
        dq.pop_front();

        if(val < 0) {
            for(int i = 0; i < -val; i++) {
                dq.push_front(dq.back());
                dq.pop_back();
            }
        }
        else {
            for(int i = 0; i < val - 1; i++) {
                dq.push_back(dq.front());
                dq.pop_front();
            }
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