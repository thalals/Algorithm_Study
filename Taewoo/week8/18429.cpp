#include<iostream>
#include<vector>
using namespace std;

int N, K, answer;
vector<int> kits;

void go(vector<int> &muscle, int idx) {
    if(kits.size() == N) {
        int weight = 500;
        for(auto i : kits) {
            int check = weight + muscle[i] - K;
            if(check >= 500){
                weight = check;
            } else return;
        }
        answer++;
        return;
    }

    for(int i = 1; i <= N; i ++) {
        bool flag = true;
        for(int j = 0; j < idx; j++) {
            if(kits[j] == i){
                flag = false;
                break;
            }
        }
        if(flag) {
            kits.push_back(i);
            go(muscle, idx + 1);
            kits.pop_back();
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> K;
    vector<int> muscle(N);
    for(int i = 1; i <= N; i++) {
        cin >> muscle[i];
    }

    go(muscle, 0);
    cout << answer;
}