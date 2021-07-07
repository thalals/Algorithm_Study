#include <bits/stdc++.h>
using namespace std;

int n;
vector<string> files;
map<string, int> mp;
void input() {
    cin >> n;
    files.resize(n);
    for(int i = 0; i < n; i++) cin >> files[i];
}

void pro() {
    for(string s : files) {
        for(int i = 0; i < s.size(); i++) {
            if(s[i] == '.') mp[s.substr(i + 1)]++;
        }
    }

    for(map<string, int>::iterator iter = mp.begin(); iter != mp.end(); iter++ ) {
        cout << iter->first << ' ' << iter->second << '\n';
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}