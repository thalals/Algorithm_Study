#include <bits/stdc++.h>
using namespace std;

vector<int> card;
vector<int> tmp;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int answer = -1e9;
    int N, M; cin >> N >> M;
    
    for(int i = 0; i < N; i++) {
        int num; cin >> num;
        card.push_back(num);
    }
    
    for(int i = 0; i < 3; i++) tmp.push_back(0);
    for(int i = 0; i < N - 3; i++) tmp.push_back(1);

    do{
        int sum = 0;
        for(int i = 0; i < tmp.size(); i++) {
            if(!tmp[i]) sum += card[i];
        } 
        if(sum <= M) answer = max(answer, sum);

    }while(next_permutation(tmp.begin(), tmp.end()));
    cout << answer << '\n';
}