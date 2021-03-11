#include<bits/stdc++.h>
using namespace std;

int n, m;
int ride[10001];

bool isOK(long long mid) {
    long long person = m;
    for(int i = 0; i < m; i++) {
        person += mid / ride[i];
    }
    cout << person << '\n';
    return person >= n;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> n >> m;

    for(int i = 0; i < m; i++) {
        cin >> ride[i];
    }

    if(n <= m) {
        cout << n;
        return 0;
    }

    long long left = 0;
    long long right = 30LL * 2000000000LL;
    long long answer = 0;

    while(left <= right) {
        long long mid = (left + right) / 2;
        
        if(isOK(mid)) {
            right = mid - 1;
            answer = mid;        
        }
        else {
            left = mid + 1;
        }
    }
    long long person = m;
    for(int i = 0; i < m; i++) {
        person += (answer - 1) / ride[i];
    }
    cout << answer << '\n';
    cout << person << '\n';
    for(int i = 0; i < m; i++) {
        if(answer % ride[i] == 0) person++;
        if(person == n) {
            cout << i + 1 << '\n';
            break;
        }
    }
    return 0;
}