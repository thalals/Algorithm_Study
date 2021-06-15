#include <iostream>
#include <math.h>
typedef long long int ll;
using namespace std;

int K, N; // 랜선의 개수 K, 필요한 랜선의 개수 N
int lan[10001];

bool isOk(long long mid) {
    long long sum = 0;
    for(int i = 1; i <= K; i++) {
        sum += lan[i] / mid;
    }
    return sum >= N;
}

int main() {
    cin >> K >> N;
    for (int i = 1; i <= K; i++)
        cin >> lan[i];

    long long left = 1;
    long long right = (long long)1 << 31;
    long long answer = 0 ;
    while (left <= right) {
        long long mid = (left + right) / 2;
        if(isOk(mid)) {
            left = mid + 1;
            answer = max(answer, mid);
        }
        else right = mid - 1;
    }

    cout << answer;
    return 0;
}