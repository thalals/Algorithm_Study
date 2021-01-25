// 선택 정렬 시간 초과, 퀵 정렬 시간 초과 롸?
#include <stdio.h>
#define ARRAY_SIZE 1000001

void quickSort(int*, int, int);

int arr[ARRAY_SIZE];

int main(void){
    int cnt;
    scanf("%d", &cnt);

    for(int i = 0; i < cnt; i++){
        scanf("%d", &arr[i]);
    }

    quickSort(arr, 0, cnt - 1);

    for(int i = 0; i < cnt; i++) printf("%d\n", arr[i]);
}

void quickSort(int* arr, int start, int end){
    if(start >= end) return;

    int left = start;
    int right = end;
    int pivot = arr[(left + right) / 2];

    while(left <= right){
        while(pivot > arr[left]) left++;
        while(pivot < arr[right]) right--;

        if(left <= right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++, right--;
        }
    }
    if(start < right) quickSort(arr, start, right);
    if(left < end) quickSort(arr, left, end);
}