/*
Problem : https://www.acmicpc.net/problem/21944
Comment : 1. recommend G x => x == 1 분류가 G인 문제 중 가장 어려운 문제 번호를 출력
                           => x == -1 분류가 G인 가장 쉬운 문제
          2. recommend2 x  => x == 1 분류 상관없이 가장 어려운 문제
                           => x == -1 분류 상관없이 가장 쉬운 문제
          3. recommend3 x L=> x == 1 분류 없이 난이도 L보다 크거나 같은 문제 중 가장쉬운 문제번호
                                     여러개면 문제 번호가 작은거 / 없다면 -1
                              x== -1 분류 없이 난이도가 L보다 작은 문제 중 가장 어려운 문제
                                     여러개면 문제 번호가 큰거 / 없다면 -1
          4. add P L G     => 난이도가 L이고 분류가 G인 문제 번호 P 추가
          5. solved P      => 문제번호 P 제거
*/

#include<bits/stdc++.h>
using namespace std;

set<pair<int, int> > _set; // 레벨, 문제
set<pair<int, int> > group[101];
map<int, int> mp; // 문제 레벨
map<int, int> group_mp; // 문제 그룹
int n, m, p, l, g;
string cmd;
void input() {
    cin >> n;
    for(int i = 1; i <= n; i++) {
        cin >> p >> l >> g;
        _set.insert({l, p});
        group[g].insert({l, p});
        mp[p] = l;
        group_mp[p] = g;
    }
    cin >> m;
}

void pro() {
    for(int i = 1; i <= m; i++) {
        cin >> cmd;
        if(cmd == "recommend") {
            int x;
            cin >> g >> x;
            if(x == 1) {
                auto iter = group[g].end();
                iter--;
                cout << iter->second << '\n';
            }
            else {
                auto iter = group[g].begin();
                cout << iter->second << '\n';
            }
        }
        else if(cmd == "recommend2") {
            int x;
            cin >> x;
            if(x == 1) {
                auto iter = _set.end();
                iter--;
                cout << (*iter).second << '\n';
            }
            else {
                auto iter = _set.begin();
                cout << (*iter).second << '\n';
            }
        }
        else if(cmd == "recommend3") {
            int x;
            cin >> x >> l;
            if(x == 1) {
                auto it = _set.lower_bound({l, 1});
                if(it != _set.end()) cout << it->second << '\n';
                else cout << -1 << '\n';
            }
            else {
                auto it = _set.lower_bound({l, 1});
                if(it == _set.begin()) {
                    cout << -1 << '\n';
                    continue;
                }
                it--;
                if(it != _set.end()) {
                    cout << it->second << '\n';
                }
                else cout << -1 << '\n';
            }
        }
        else if(cmd == "add") {
            cin >> p >> l >> g;
            _set.insert({l, p});
            group[g].insert({l,p});
            mp[p] = l;
            group_mp[p] = g;
        }
        else {
            cin >> p;
            int level = mp[p];
            int g = group_mp[p];
            _set.erase({level, p});
            group[g].erase({level, p});
            mp[p] = 0;
            group_mp[p] = 0;
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