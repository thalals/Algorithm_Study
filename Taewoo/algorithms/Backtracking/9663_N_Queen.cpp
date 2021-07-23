#include<iostream>
#include<vector>
#include<algorithm>
#include<cmath>
using namespace std;

int graph[15][15];
int N, answer;
vector<int> v;
void pro(int idx) {
    if(idx == N) {
        answer++;
        return;
    }

    for(int i = 0; i < N; i++) {
        bool flag = true;
        for(int j = 0; j < v.size(); j++) {
            if(v[j] == i || abs(v[j] - i) == abs(j - idx)) {
                flag = false;
                break;
            }
        }
        if(flag) {
            v.push_back(i);
            pro(idx + 1);
            v.pop_back();
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    pro(0);
    cout << answer;
}