/*
Problem : https://www.acmicpc.net/problem/1174
Comment : 가장 큰 줄어드는 숫자는 1,000,000
          9876543210
*/

#include<bits/stdc++.h>
using namespace std;

int N;
string num[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
vector<string> v;
void input() {
    cin >> N;
}

void go(int idx, int n, int back, string s) {
    if(idx == n) {
        v.push_back(s);
        return;
    }

    for(int i = 0; i < back; i++) {
        go(idx + 1, n, i, s + num[i]);
    }
}

void pro() {
    if(N > 1023) cout << -1;
    else {
        for(int i = 1; i <= 10; i++) go(0, i, 10, "");
        cout << v[N-1];
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    input();
    pro();
}