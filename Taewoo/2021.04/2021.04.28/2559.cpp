#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int main() {
    int n, k;
    cin >> n >> k;
    
    vector<int> arr;
    arr.push_back(0);

    for(int i = 0; i < n; i++) {
        int tmp; cin >> tmp;
        arr.push_back(tmp + arr[i]);
    }

    int answer = -1e9;
    for(int i = k; i <= n; i++) {
        answer = max(answer, arr[i] - arr[i - k]);
    }
    cout << answer;
}