#include <stdio.h>
#include <string.h>

char arr[1000];
char maxArr[1000] = {-1, };

int main(void){
    int cnt;
    scanf("%d", &cnt);

    for(int i = 0; i < cnt; i++){
        int val;
        scanf("%d", &val);
        arr[i] = val;
    }


    for(int j = 0; j < strlen(arr); j++){
        for(int k = 1; k < strlen(arr)-j; k++){
            if(arr[j] < arr[j+k]){
                maxArr[j] = arr[j+k];
                k = strlen(arr)-j;
            }
        }
        if(arr[j] == '0') maxArr[j] = -1;
    }
    for(int a = 0; a < strlen(arr); a++) printf("%d ", maxArr[a]);
}