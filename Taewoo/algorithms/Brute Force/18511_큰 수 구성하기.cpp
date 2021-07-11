#include <bits/stdc++.h>
using namespace std;

int N, K;
vector<int> v;
void input() {
    cin >> N >> K;
    v.resize(K);
    for(int i = 1; i<= K; i++) cin >> v[i];
}

int selected[5];
int answer;
void go(int k, int cnt) {
    if(k == cnt) {
        string check;
        int tmp;
        for(int i = 0; i < cnt; i++) check += to_string(selected[i]);
        tmp = stoi(check);
        if(N < tmp) return;
        answer = max(answer, tmp);
        return;
    }

    for(int i = 1; i <= K; i++) {
        selected[k] = v[i];
        go(k + 1, cnt);
        selected[k] = 0;
    }
}

void pro() {
    string size = to_string(N);
    for(int i = 1; i <= size.size(); i++) go(0, i);
    cout << answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}
