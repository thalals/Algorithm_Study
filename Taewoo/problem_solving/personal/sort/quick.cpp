// 퀵 정렬
// 기준 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 방법
// 일반적인 상황에서 가장 많이 사용되는 정렬 알고리즘
// 병합 정렬과 더불어 대부분의 프로그래밍 언어의 정렬 라이브러리의 근간이 되는 알고리즘
// 가장 기본적인 퀵 정렬은 첫 번째 데이터를 기준 데이터(Pivot)로 설정
// 퀵 정렬이 빠른 이유:
// 이상적인 경우 분할이 절반씩 일어난다면 전체 연산 횟수로 O(NlogN)
// 너비 * 높이 = N * logN
// 최악의 경우 O(N^2)

#include<bits/stdc++.h>
using namespace std;
int n = 10;
int target[10] = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

void quickSort(int* target, int start, int end) {
    if(start >= end) return;
    int pivot = start;
    int left = start + 1;
    int right = end;
    while(left<=right) {
        while(left<=end && target[left] <= target[pivot]) left++;
        while(right>start && target[right] >= target[pivot]) right--;
        if(left > right) swap(target[pivot], target[right]);
        else swap(target[left], target[right]);
    }
    quickSort(target, start, right - 1);
    quickSort(target, right + 1, end);
}

int main() {
    quickSort(target, 0, n-1);
    for(int i : target) cout << i <<' ';
}