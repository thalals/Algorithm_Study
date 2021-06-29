#include <bits/stdc++.h>
using namespace std;

int n;
priority_queue<int, vector<int>, greater<int> > pq;
void input() {
    cin >> n;
}

void pro() {
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            int x;
            cin >> x;

            pq.push(x);
            if(pq.size() == n + 1)
                pq.pop();
        }
    }
    
    while(pq.size() == 1) pq.pop();
    cout << pq.top();
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}