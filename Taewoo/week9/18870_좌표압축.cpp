#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int arr[1000001];
int main() {
    int N; cin >> N;
    vector<int> vec(N);

    for(int i = 0; i < N; i++) {
        cin >> arr[i];
        vec[i] = arr[i];    
    }

    sort(vec.begin(), vec.end());
    vec.erase(unique(vec.begin(), vec.end()), vec.end());

    for(int i = 0; i < N; i++) {
        int answer = lower_bound(vec.begin(), vec.end(), arr[i]) - vec.begin();
        cout << answer << ' ';
    }
}