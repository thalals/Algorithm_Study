/*
Problem : https://www.acmicpc.net/problem/1158
Comment : 그저 스택이용...
*/
#include <bits/stdc++.h>
using namespace std;

int T;
void input() {
    cin >> T;
}

void pro() {
    while(T--) {
        string s;
        cin >> s;
        int cnt = 0;
        for(int i = 0; i < s.size(); i++) {
            if(s[i] == '(') cnt++;
            else {
                cnt--;
                if(cnt < 0) {
                    cout << "NO" << "\n";
                    break;
                }
            }
        }
        if(cnt == 0) cout << "YES" << "\n";
        else if(cnt > 0) cout << "NO" << "\n";
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}