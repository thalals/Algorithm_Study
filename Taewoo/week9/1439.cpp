#include<bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string s; cin >> s;
    int zero = 0, one = 0;

    for(int i = 0; i < s.size(); i++) {
        if(s[i] != s[i + 1]) {
            if(s[i] == '0') zero += 1;
            else one += 1;
        }
    }
    cout << min(zero, one);
}