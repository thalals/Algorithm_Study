#include<bits/stdc++.h>
using namespace std;
vector<int> vec;

int findNumber(int N) {
    int left = 0;
    int right = vec.size() - 1;
    while (left < right) {
        int mid = (left + right) / 2;
        if(vec[mid] < N) {
            left = mid + 1;
        }
        else {
            right = mid;
        }
    }
    return vec[(left + right) / 2] == N;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M, num; 
    cin >> N;
    for(int i = 0; i < N; i++) {
        cin >> num;
        vec.push_back(num);
    }
    sort(vec.begin(), vec.end());
    
    cin >> M;
    for(int i = 0; i < M; i++) {
        cin >> num;
        cout << findNumber(num) << '\n'; 
    }
}