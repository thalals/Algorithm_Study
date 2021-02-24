#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int N; cin >> N;
    vector<pair<int,int>> v(N);
    for(int i = 0; i < N; i++)
        cin >> v[i].first >> v[i].second;
    
    sort(v.begin(), v.end());

    priority_queue<int, vector<int>, greater<int>>pq;
    for(int i = 0; i < N; i++) {
        if(pq.size() < v[i].first) {
            pq.push(v[i].second);
        }
        else {
            if(pq.top() < v[i].second) {
                pq.pop();
                pq.push(v[i].second);
            }
        }
    }

    int sum = 0;
    while(!pq.empty()) {
        sum += pq.top();
        pq.pop();
    }
    cout << sum << '\n';
}
// {2, 20} {2, 25}, {3, 30}