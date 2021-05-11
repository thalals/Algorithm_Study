#include <iostream>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    int arr[10000];

    for(int i = 0; i < n; i++) 
        cin >> arr[i];

    int left = 0, right = 0;
    int answer = 0; int sum = 0;

    while(left <= right && right <= n) {
        if(sum >= m) {
            if(sum == m) answer++;
            sum -= arr[left++];
        }
        else if(sum < m) {
            if(right == n) break;
            sum += arr[right++];
        }
    }
    cout << answer << '\n';
}