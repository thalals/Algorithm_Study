/*
    1. k을 맞추면서 넣을 수 있는 물건들 중 가치의 합이 최대가 되는 경우 >> dp[i] 가방 무게가 i 남았을 때의 가치가 최대일 경우

    > 가방에 넣는 경우 >> 어떻게 넣어야 최대값을 넣을 수 있냐? >> 다따져보자..
                                                    >> 두개의 무게가 같은 경우는 어떻게 구분하지??
                                                    >> dp[i][j] 현재 i 남은 무게 / j번째 물건 선택했을때
    > 가방에 넣지 않는 경우 >> 그냥 안넣으면 되고,
*/

#include <iostream>
#include <cstring>
using namespace std;

int n, k;
int value[101];
int weight[101];
int dp[100001][101];

void input() {
    cin >> n >> k;
    for(int i = 0; i < n; i++) {
        cin >> weight[i] >> value[i];
    }
}
// top bottom 
// bottom up
int get_dp(int remain, int idx) { 
    if(idx == n) return 0;

    int &ret = dp[remain][idx];
    if(ret != -1) return ret;
    ret = 0;
    // 현재 물건의 무게가 남아있는 배낭 무게보다 가벼울 경우 넣고 진행하기
    // 그냥 않넣고 가기
    if(weight[idx] <= remain) ret = max(ret, get_dp(remain - weight[idx], idx + 1) + value[idx]);
    ret = max(ret, get_dp(remain, idx + 1));
    return ret;
}

void pro() {
    memset(dp, -1, sizeof(dp));
    cout << get_dp(k, 0);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    input();
    pro();
    return 0;
}