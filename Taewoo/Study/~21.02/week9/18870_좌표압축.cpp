/*
Comment : lower_bound로 했을 땐 바로 답이 나왔으나
          이진 탐색을 직접 구현했는데 파라미터를 주소값 참고가 아니고
          직접 vector<int> vec로 날려버려서 시간이 너무 오래 걸려 시간초과가 발생함..
*/

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
