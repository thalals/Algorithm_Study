#include <bits/stdc++.h>
using namespace std;

int T;
int dp[41][2];
int get_dp(int x, int y) {
    if(dp[x][y] != -1) return dp[x][y];
    else return dp[x][y] = get_dp(x - 1, y) + get_dp(x - 2, y);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> T;
    fill(&dp[0][0], &dp[0][0] + 41 * 2, -1);
    dp[0][0] = 1, dp[0][1] = 0;
    dp[1][0] = 0, dp[1][1]= 1;

    while(T--) {
        int num; cin >> num;
        
        for(int i = 0; i < 2; i++)
            get_dp(num, i);
        
        cout << dp[num][0] << ' ' << dp[num][1] << '\n';
    }

}