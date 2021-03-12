#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int arr[1000001];
vector<int> vec;
int binary(int left, int right, int key, vector<int> &vec) {
    while(left < right) {
        int mid = (left + right) / 2;
        if(vec[mid] < key){
            left = mid + 1;
        }
        else {
            right = mid;
        }
    }
    return (left + right) / 2;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N; cin >> N;
    
    vec.resize(N);
    for(int i = 0; i < N; i++) {
        cin >> arr[i];
        vec[i] = arr[i];    
    }
    sort(vec.begin(), vec.end());
    vec.erase(unique(vec.begin(), vec.end()), vec.end());

    for(int i = 0; i < N; i++) {
        int ret = binary(0, vec.size() - 1, arr[i], vec);
        cout << ret << ' ';
    }
}
