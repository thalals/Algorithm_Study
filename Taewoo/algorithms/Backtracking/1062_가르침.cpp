#include<bits/stdc++.h>
using namespace std;

int N, K, ans, alpha[26];
vector<string> v;
void input() {
    cin >> N >> K;
    v.resize(N);
    for(int i = 0; i < N; i++) {
        string s; cin >> s;
        s = s.substr(4);
        s = s.substr(0, s.size() - 4);
        v[i] = s;
    }
}

int isOk() {
    int ret = 0;
    for(int i = 0; i < v.size(); i++) {
        string s = v[i];
        bool flag = true;
        for(int j = 0; j < s.size(); j++) {
            if(alpha[s[j] - 'a'] == false) {
                flag = false;
                break;
            }
        }
        if(flag) ret++;
    }
    return ret;
}

void go(int idx, int cnt) {
    if(cnt == K) {
        int ret = isOk();
        ans = max(ans, ret);
        return;
    }
    for(int i = idx + 1; i < 26; i++) {
        if(alpha[i]) continue;
        alpha[i] = 1;
        go(i, cnt + 1);
        alpha[i] = 0;
    }
}

void pro() {
    alpha['a' - 'a'] = true;
    alpha['n' - 'a'] = true;
    alpha['t' - 'a'] = true;
    alpha['i' - 'a'] = true;
    alpha['c' - 'a'] = true;
    if(K < 5) cout << 0;
    else if(K == 26) cout << N;
    else {
        K -= 5;
        go(-1, 0);
        cout << ans;
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    input();
    pro();
}