#include <bits/stdc++.h>
using namespace std;

int n;
bool go(string cur) {
    if(cur.size() == n) {
        cout << cur;
        return true;
    }

    for(int i = 1; i <= 3; i++) {
        string next = cur + to_string(i);
        bool flag = false;

        for(int j = 1; j <= next.size()/2; j++) {
            string check1 = next.substr(next.size()-j, j);
            string check2 = next.substr(next.size()-(2*j), j);
            if(check1 == check2) flag = true;
        }
        if(flag) continue;
        if(go(next)) return true;
    }
    return false;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    go("");
}