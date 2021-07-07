#include <stdio.h>
#define SIZE 100

int arr[SIZE];

int main(void){
    int cnt, total;
    int val, max = 0;
    scanf("%d %d", &cnt, &total);

    for(int i = 0; i < cnt; i++){
        scanf("%d", &arr[i]);
    }

    for(int i = 0; i < cnt - 2; i++){
        val = arr[i];
        for(int j = i + 1; j < cnt - 1; j++){
            val += arr[j];
            for(int k = j + 1; k < cnt; k++){
                val += arr[k];
                if(val > max && val <= total){
                    max = val;
                    val -= arr[k];
                }
                else val -= arr[k];
            }
            val -= arr[j];
        }
        val = 0;
    }
    printf("%d", max);

    return 0;
}