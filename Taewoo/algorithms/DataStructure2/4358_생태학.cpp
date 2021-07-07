#include<bits/stdc++.h>
using namespace std;

string s;
map<string, int> mp;
int total;
void input() {
    while(getline(cin, s)) {
        mp[s]++;
        total++;
    }
}

void pro() {
    cout.precision(4);
    cout << fixed;

    for(pair<string, int> p : mp)
        cout << p.first << ' ' << ((double) p.second / total) * 100 << '\n';
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}