/*
Problem: 나는야 포켓몬 마스터 이다솜 (1620)
https://www.acmicpc.net/problem/1620
Comment: 문제가 너무 길다...
*/

#include<bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    map<string, int> mp;
    map<int, string> mp2;

    int n, m; cin >> n >> m;
    string name;
    for(int i = 1; i <= n; i++) {
        cin >> name;
        mp[name] = i;
        mp2[i] = name;
    }

    string search;
    for(int i = 1; i <= m; i++) {
        cin >> search;
        if(atoi(search.c_str()) == 0) {
            cout << mp[search] << '\n';
        }
        else {
            cout << mp2[atoi(search.c_str())] << '\n';
        }
    }
}