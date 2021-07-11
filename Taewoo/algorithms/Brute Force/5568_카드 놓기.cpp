#include <bits/stdc++.h>

using namespace std;

int n, k;
vector<int> cards;
int selected[10];
int used[10];
set<string> s;

void input() {
    cin >> n >> k;
    cards.resize(n);
    for(int i = 0; i < n; i++)cin >> cards[i];
}

void go(int cnt) {
    if(cnt == k) {
        string number;
        for(int i = 0; i <= k; i++)
            number += to_string(selected[i]);
        
        s.insert(number);
        return;
    }
    
    for(int i = 0; i < cards.size(); i++) {
        if(used[i]) continue;
        used[i] = 1;
        selected[cnt] = cards[i];
        go(cnt + 1);
        used[i] = 0;
        selected[cnt] = 0;
    }
}

void pro() {
    go(0);
    cout << s.size();
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}
