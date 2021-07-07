// 삽입 정렬
// 처리되지 않은 데이터를 하나씩 골라 적절한 위치에 삽입
// 시간 복잡도는 O(N^2), 거의 거의 정렬되어 있는 상태라면 매우 빠르게 동작하며 최선의 경우 O(N)
#include<bits/stdc++.h>
using namespace std;
int n = 10;
int target[10] = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

int main() {
    for(int i = 1; i < n; i++){
        for(int j = i; j > 0; j--) {
            if(target[j] < target[j-1]) swap(target[j], target[j-1]);
            else break;
        }
    }

    for(int i : target) cout << i << ' ';
}