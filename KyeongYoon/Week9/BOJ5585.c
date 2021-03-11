// BOJ5585 거스름돈
#include <stdio.h>

int main(void){
    int pay;
    scanf("%d", &pay);
    int change = 1000 - pay;

    int w500 = change / 500;
    int w100 = (change % 500) / 100;
    int w50 = (change % 100) / 50;
    int w10 = (change % 50) / 10;
    int w5 = (change % 10) / 5;
    int w1 = (change % 5) / 1;

    printf("%d", w500 + w100 + w50 + w10 + w5 + w1);

    return 0;
}