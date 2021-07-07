#include <stdio.h>
#define SIZE 50

int arr[SIZE][2];

int main(void){
    int cnt;
    scanf("%d", &cnt);

    for(int i = 0; i < cnt; i++){
        scanf("%d %d", &arr[i][0], &arr[i][1]);
    }

    for(int i = 0; i < cnt; i++){
        int rank = 1;
        for(int j = 0; j < cnt; j++){
            if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) rank++;
        }
        printf("%d ", rank);
    }
}