#include<iostream>
#include<vector>
using namespace std;
int N, M;
vector<int> vec;
void backtracking(int idx) {
    if(vec.size() == M) {
        for(int i : vec) cout << i << ' ';
        cout << '\n';
        return;
    }

    for(int i = 1; i <= N; i++) {
        bool isOk = true;
        for(int j = 0; j < idx; j++) {
            if(vec[j] == i) {
                isOk = false;
                break;
            }
        }
        if(isOk) {
            vec.push_back(i);
            backtracking(idx + 1);
            vec.pop_back();
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M;

    backtracking(0);
}