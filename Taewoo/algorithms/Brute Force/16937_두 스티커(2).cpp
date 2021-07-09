#include<bits/stdc++.h>
using namespace std;

struct Info{
    int r, c, type;
};

int h, w, n;
vector<Info> v;
void input() {
    cin >> h >> w >> n;
    for(int i = 0; i < n; i++) {
        int r, c;
        cin >> r >> c;
        if(r != c) {
            v.push_back({r, c, i});
            v.push_back({c, r, i});
        }
        else v.push_back({r, c, i});
    }
}


int selected[101];
int used[101];
int answer;
void dfs(int k) {
    if(k == 3) {
        int r1 = v[selected[1]].r; int c1 = v[selected[1]].c;
        int r2 = v[selected[2]].r; int c2 = v[selected[2]].c;

        if(r1 + r2 <= h)
            if(max(c1, c2) <= w) answer = max(answer, r1*c1 + r2*c2);
        
        if(c1 + c2 <= w)
            if(max(r1, r2) <= h) answer = max(answer, r1*c1 + r2*c2);
        return;
    }

    for(int i = selected[k - 1] + 1; i <= v.size(); i++) {
        if(used[v[i - 1].type]) continue;
        used[v[i - 1].type] = 1;
        selected[k] = i - 1;
        dfs(k + 1);
        used[v[i - 1].type] = 0;
        selected[k] = 0;
    }
}

void pro() {
    dfs(1);
    cout << answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
}