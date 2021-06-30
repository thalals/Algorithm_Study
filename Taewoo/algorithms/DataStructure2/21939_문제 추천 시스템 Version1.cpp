/*
Problem : https://www.acmicpc.net/problem/21939
Comment : 1. recommend x => x가 1이면 어려운 문제 뽑기 / 여러 개면 문제번호가 큰걸로..
                         => x가 -1이면 쉬운 문제 뽑기 / 여러 개면 문제번호가 작은걸로..
          2. add P L     => 난이도가 L인 문제번호 P를 추가
          3. solved P    => 문제번호 P 제거
*/

#include<bits/stdc++.h>
using namespace std;

int n, m, p, l;
string cmd;
set<pair<int, int> > problems;
unordered_map<int, int> mp;
void input() {
    cin >> n;
    for(int i = 1; i <= n; i++) {
        cin >> p >> l;
        problems.insert({l, p});
        mp[p] = l;
    }
    cin >> m;
}

void pro() {
    for(int i = 1; i <= m; i++) {
        cin >> cmd;

        if(cmd == "recommend") {
            int x;
            cin >> x;
            if(x == 1) {
                std::set<pair<int, int> >::iterator iter = problems.end();
                cout << (--iter)->second << '\n';
            }
            else {
                std::set<pair<int, int> >::iterator iter = problems.begin();
                cout << iter->second << '\n';
            }
        }
        else if(cmd == "add") {
            cin >> p >> l;
            problems.insert({l, p});
            mp[p] = l;
        }
        else if(cmd == "solved") {
            cin >> p;
            int level = mp[p];
            problems.erase({level, p});
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