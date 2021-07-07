/*
Problem : https://www.acmicpc.net/problem/1966
Comment : 큐와 우선순위 큐를 이용하여 중요도 높은 것을 뽑기
*/
#include <bits/stdc++.h>
using namespace std;
int T;
void input() {
    cin >> T;
}

int cnt;
int n, m, importance;
void pro() {
    for(int i = 0; i < T; i++) {
        cnt = 0;
        cin >> n >> m;
        queue<pair<int, int> > q;
        priority_queue<int> pq;

        for(int j = 0; j < n; j++) {
            cin >> importance;
            q.push({j, importance});
            pq.push(importance);
        }

        while(!q.empty()) {
            int idx = q.front().first;
            int val = q.front().second;
            q.pop();
            if(pq.top() == val) {
                pq.pop();
                cnt++;
                if(idx == m) {
                    cout << cnt << "\n";
                    break;
                }
            }
            else q.push({idx, val});
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