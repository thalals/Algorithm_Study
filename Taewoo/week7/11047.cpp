#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int N, K; cin >> N >> K;
    
    vector<int> money(N);
    for(int i = 0; i < N; i++) {
        cin >> money[i];
    }
    int result = 0;
    sort(money.begin(), money.end(), greater<int>());
    
    for(int i = 0; i < N; i++) {
        while(K >= money[i]) {
            K -= money[i];
            result++;
        }
        if(K == 0) break;
    }
    cout << result;
}