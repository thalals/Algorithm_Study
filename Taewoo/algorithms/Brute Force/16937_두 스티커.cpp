#include<bits/stdc++.h>
using namespace std;

int h, w, n;
vector<int> r;
vector<int> c;
void input() {
    cin >> h >> w;
    cin >> n;
    r.resize(n); c.resize(n);
    for(int i = 0; i < n; i++) cin >> r[i] >> c[i];
}

int answer;

bool check(int r1, int c1, int r2, int c2) {
    if(r1 + r2 <= h && max(c1, c2) <= w) return true;
    if(max(r1, r2) <= h && c1 + c2 <= w) return true;
    return false;
}

bool isOk(int r1, int c1, int r2, int c2) {
    if(check(r1, c1, r2, c2)) return true; // ?•ˆ, ?•ˆ
    if(check(c1, r1, r2, c2)) return true; // ?šŒ, ?•ˆ
    if(check(r1, c1, c2, r2)) return true; // ?•ˆ, ?šŒ
    if(check(c1, r1, c2, r2)) return true; // ?šŒ, ?šŒ
    return false;
}

void pro() {
    for(int i = 0; i < n; i++) {
        for(int j = i + 1; j < n; j++) {
            int r1 = r[i]; int c1 = c[i];
            int r2 = r[j]; int c2 = c[j];
            if(isOk(r1, c1, r2, c2)) answer = max(answer, r1*c1 + r2*c2);
        }
    }
    cout << answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}