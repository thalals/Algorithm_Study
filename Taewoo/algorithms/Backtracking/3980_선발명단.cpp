#include <bits/stdc++.h>
using namespace std;

int T, ans;
int arr[11][11], used[11];
void process(int idx, int val) {
    if(idx == 11) {
        ans = max(ans, val);
        return;
    }
    
    for(int i = 0; i < 11; i++) {
        if(used[i] || !arr[idx][i]) continue;
        used[i] = 1;
        process(idx + 1, val + arr[idx][i]);
        used[i] = 0;
    }
}

void input() {
    cin >> T;
    for(int tc = 0; tc < T; tc++) {
        for(int i = 0; i < 11; i++) 
            for(int j = 0; j < 11; j++) 
                cin >> arr[i][j];
        
        fill(used, used + 11, 0);
        ans = 0;
        process(0, 0);
        cout << ans << '\n';
    }
}


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    input();
}