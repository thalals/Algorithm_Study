#include <bits/stdc++.h>
using namespace std;

int n;
string s;
int alpha[26];
string ans;
void process(int idx) {
    if(idx == s.size()) {
        cout << ans << '\n';
        return;
    }

    for(int i = 0; i < 26; i++) {
        if(!alpha[i]) continue;
        alpha[i]--;
        ans += 'a' + i;
        process(idx+1);
        ans.erase(ans.end() - 1);
        alpha[i]++;
    }
}

void input() {
    cin >> n;
    while(n--) {
        fill(alpha, alpha+26, 0);
        cin >> s;
        for(auto it: s) alpha[it - 'a']++;
        process(0); 
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    input();
}  