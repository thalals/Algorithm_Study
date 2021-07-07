#include <bits/stdc++.h>

using namespace std;

int n;
void input() {
    cin >> n;
}

bool flag;
void pro() {
    int w, x, y, z;
    for(int a = 0; a < 224; a++) {
        for(int b = 0; b < 224; b++) {
            for(int c = 0; c < 224; c++) {
                for(int d = 0; d < 224; d++) {
                    if(pow(a, 2) + pow(b, 2) + pow(c, 2) + pow(d, 2) == n) {
                        w = a; x = b; y = c; z = d;
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
            if(flag) break;
        }
        if(flag) break;
    }
    int answer = 0;
    if(w != 0) answer++;
    if(x != 0) answer++;
    if(y != 0) answer++;
    if(z != 0) answer++;
    cout << answer << "\n";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}
