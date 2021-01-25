// 선택 정렬
#include <stdio.h>
#define ARRAY_SIZE 1000001

int arr[ARRAY_SIZE];

int main(void){
    int cnt;
    scanf("%d", &cnt);

    for(int i = 0; i < cnt; i++){
        scanf("%d", &arr[i]);
    }
    for(int i = 0; i < cnt - 1; i++){
        int min_index = i;
        for(int j = i + 1; j < cnt; j++){
            if(arr[min_index] > arr[j]) min_index = j;
        }
            int tmp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = tmp;
    }
    for(int i = 0; i < cnt; i++){
        printf("%d ", arr[i]);
    }
}