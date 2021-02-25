#include <stdio.h>
#define MAXDAY 15
#define MAXTIME 5
#define MAXPAY 1000

int arr_time[MAXTIME];
int arr_pay[MAXPAY];

int main(void){
    int day;
    int time, pay;
    int MAXmoney;

    scanf("%d", &day);

    for(int i = 0; i < day; i++){
        scanf("%d %d", &time, &pay);
        arr_time[i] = time;
        arr_pay[i] = pay;
    }

    for(){
        
    }
}