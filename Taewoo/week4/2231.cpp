#include<iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int answer = 1e9;
    int N; cin >> N;

    // 256 <=  245    2 + 4 + 5 + 245
    for(int i = 1; i <= 1000000; i++) {
        int sum = i;
        int tmp = i;
        
        while(tmp) {
            sum += tmp % 10;
            tmp /= 10;
        }
        if(sum == N) {
            cout << i << '\n';
            return 0;
        }
    }
    cout << 0 << '\n';
}