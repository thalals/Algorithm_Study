#include <stdio.h>

int main(void){
    int num;
    scanf("%d", &num);

    int movie = 1000 * (num-1) + 666;

    printf("%d", movie);
}