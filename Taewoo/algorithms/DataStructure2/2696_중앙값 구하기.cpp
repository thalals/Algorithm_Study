#include<bits/stdc++.h>
using namespace std;

int t;
void input() {
    cin >> t;
}

void pro() {
    for(int tc = 0; tc < t; tc++) {
        int n;
        priority_queue<int, vector<int>, greater<int> > pq_max;
        priority_queue<int, vector<int>, less<int> > pq_min;
        vector<int> ans;

        cin >> n;
        int tmp;
        cin >> tmp;
        ans.push_back(tmp);
        pq_max.push(tmp);

        for(int i = 1; i < n; i++) {
            int data;
            cin >> data;
            if(i % 2 == 0) {
                if(pq_min.top() < data) {
                    int tmp = pq_min.top();
                    pq_min.pop();
                    pq_min.push(data);
                    pq_max.push(tmp); 
                } else pq_max.push(data);
                ans.push_back(pq_max.top());
            } else {
                if(pq_max.top() > data) {
                    int tmp = pq_max.top();
                    pq_max.pop();
                    pq_max.push(data);
                    pq_min.push(tmp); 
                } else {
                    pq_min.push(data);
                }
            }
        }

        cout << ans.size() << '\n';
        for(int i = 0; i < ans.size(); i++) {
            if(i == ans.size() - 1) cout << ans[i] << '\n';
            else if((i + 1) % 10) cout << ans[i] << '\n';
            else cout << ans[i] << '\n';
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