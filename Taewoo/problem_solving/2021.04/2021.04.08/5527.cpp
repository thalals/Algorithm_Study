#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int n;
int ret[100001];
int arr[100001];
void input() {
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    arr[n] = arr[n - 1];
}
void pro() {
    int answer = 0;
    int previous = arr[0];
    int idx = 1;
    for(int i = 1; i <= n; i++) {
        if(previous == arr[i]) {
            ret[idx]++;
            idx++;
        }
        if(previous != arr[i]) {
            ret[idx]++;
        }
        previous = arr[i];
    }

    for(int i = 0; i <= idx -1; i++){
        // cout << ret[i] << ' ';
        answer = max(answer, ret[i] + ret[i + 1] + ret[i + 2]);
    }
    cout << answer;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    input();
    pro();
    return 0;
}
//0 1 2 3 4 5 6 7 8 9
//1 1 0 0 1 0 1 1 1 0