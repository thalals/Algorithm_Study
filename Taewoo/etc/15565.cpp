#include <bits/stdc++.h>
using namespace std;
int N, K;
vector<int> vec;
int answer = 1e9;

int solve() {
    int left = 0; int right = 0;
    int lion = 0;

    while(right != N+1) {
        if(lion < K) { //라이언이 K보다 작으면 증가시키기
            if(vec[right] == 1){
                lion++;
            }
            right++;
        }        
        else {
            //라이언이 K보다 많으면
            answer = min(answer, right-1 - (left - 1));
            if(vec[left] == 1){
                lion--;
            }
            left++;
        }
    }
    return answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> N >> K;

    for(int i = 0; i < N; i++) {
        int tmp; cin >> tmp;
        vec.push_back(tmp);
    }
    solve();
    if(answer == 1e9) {
        cout << -1 << '\n';
    }else {
        cout << answer << '\n';
    }
}