// BOJ1439 뒤집기
#include <stdio.h>
#include <string.h>
#define SIZE 1000000

char arr[SIZE];

int main(void){
    int zeroPoint = 0, onePoint = 0;
    int flag = 0;
    int cnt = 0;
    scanf("%s", arr);

    if(arr[0] == '0'){
        flag = 0;
        zeroPoint++;
    }
    else{
        flag = 1;
        onePoint++;
    }

    for(int i = 0; i < strlen(arr) - 1; i++){
        if(arr[i] != arr[i+1]){
            if(flag == 0){
                onePoint++;
                flag = 1;
            }
            else{
                zeroPoint++;
                flag = 0;
            }
        }
    }

    if(zeroPoint < onePoint) cnt = zeroPoint;
    else cnt = onePoint;

    printf("%d", cnt);
}