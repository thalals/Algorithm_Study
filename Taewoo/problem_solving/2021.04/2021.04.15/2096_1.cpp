/*
Problem : 내려가기
Comment : 메모리 초과 해결
        : 생각보다 메모리초과해결하기 힘들었떤 문제
*/
#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    
    int n; cin >> n;
    int maxDP[3], minDP[3];
    fill(maxDP, maxDP + 3, 0);
    fill(minDP, minDP + 3, 0);
    for(int i = 0; i < n; i++) {
        int cur[3], max_tmp[3], min_tmp[3];
        for(int j = 0; j < 3; j++) {
            cin >> cur[j];
            max_tmp[j] = maxDP[j];
            min_tmp[j] = minDP[j];
        }
        maxDP[0] = (max(max_tmp[0], max_tmp[1]) + cur[0]);
        maxDP[1] = (max({max_tmp[0], max_tmp[1], max_tmp[2]}) + cur[1]);
        maxDP[2] = (max(max_tmp[1], max_tmp[2]) + cur[2]);

        minDP[0] = (min(min_tmp[0], min_tmp[1]) + cur[0]);
        minDP[1] = (min({min_tmp[0], min_tmp[1], min_tmp[2]}) + cur[1]);
        minDP[2] = (min(min_tmp[1], min_tmp[2]) + cur[2]);
    }
    cout << max({maxDP[0], maxDP[1], maxDP[2]}) << ' ' << min({minDP[0], minDP[1], minDP[2]});

}
