// 선택정렬
// 처리되지 않은 데이터 중에서 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸는 것
// N번 만큼 가장 작은 수를 찾아서 맨 앞으로 보내야함
// N + (N-1) + (N-2) + 2 -> (N^2 + N - 2) /2 -> O(N^2)
#include<bits/stdc++.h>
using namespace std;
int n = 10;
int target[10] = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
int main(){
    for(int i = 0; i < n; i ++) {
        int min_index = i;
        for(int j = i + 1; j < n; j++) {
            if(target[min_index] > target[j]) min_index = j;
        }
        swap(target[i], target[min_index]);
    }
    for(int i : target) cout << i << ' ';
}