#include <bits/stdc++.h>
using namespace std;

int t, n;
void input() {
    cin >> t;
}

void pro() {
    while(t--) {
        cin >> n;
        map<int, int> mp;

        for(int i = 0; i < n; i++) {
            char cmd;
            cin >> cmd;
            int x;
            cin >> x;

            if(cmd == 'I') mp[x] += 1;
            
            else {
                if(mp.empty()) continue;
                if(x == -1) {
                    if(mp.begin()->second == 1) mp.erase(mp.begin()->first);
                    else mp.begin()->second --;
                }
                else {
                    if(mp.rbegin()->second == 1) mp.erase(mp.rbegin()->first);
                    else mp.rbegin()->second --;
                }
            }
        }
        if(mp.empty()) cout << "EMPTY\n";
        else cout << mp.rbegin()->first << ' ' << mp.begin()->first << '\n';
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}