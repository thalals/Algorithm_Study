#include <bits/stdc++.h>
using namespace std;

int card[101];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int answer = -1e9;
    int N, M; cin >> N >> M;
    
    for(int i = 0; i < N; i++)
        cin >> card[i];

    for(int i = 0; i < N; i++) {
        for(int j = i + 1; j < N; j++) {
            for(int k = j + 1; k < N; k++){
                int sum = card[i] + card[j] + card[k];
                if(sum <= M) answer = max(answer, sum);
            }
        }
    }
    cout << answer << '\n';
}