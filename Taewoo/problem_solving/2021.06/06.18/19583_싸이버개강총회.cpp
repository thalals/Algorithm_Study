/*
Comment : 진법을 구하는 방법 여러개가 존재하네...
*/
#include <bits/stdc++.h>
using namespace std;
string S, E, Q;
void input() {
    cin >> S >> E >> Q;
}

int s_time, e_time, q_time;
void convertTime() {
    s_time = stoi(S.substr(0, 2)) * 100 + stoi(S.substr(3, 2));
    e_time = stoi(E.substr(0, 2)) * 100 + stoi(E.substr(3, 2));
    q_time = stoi(Q.substr(0, 2)) * 100 + stoi(Q.substr(3, 2));
}

string t, name;
map<string, int> mp;
int cnt;
void pro() {
    convertTime();

    while(!cin.eof()) {
        cin >> t >> name;
        int now_time = stoi(t.substr(0,2)) * 100 + stoi(t.substr(3,2));

        if(now_time <= s_time) mp[name] = 1;
        else if(now_time >= e_time && now_time <= q_time)
            if(mp[name] == 1) mp[name] = 2;
    }

    for(auto it = mp.begin(); it != mp.end(); it++)
        if(it->second == 2) cnt++;
    
    cout << cnt;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}