#include <stdio.h>
#include <math.h>

int main(void){
    int num;
    scanf("%d", num);

    int cnt;
    for(cnt = 10; cnt < 1000000; cnt*10){
        if(num / cnt != 0) continue;
        else{
            cnt /= 10;
            break;
        }
    }

    int x = 0, y = 0, z = 0;
    x = num / cnt;
    int cal = num - cnt * x;

    for(int i = 0, i < 10; i++){
        for(int j = 0; j < 10; j++){
            if(10*i + 1*j == cal )
        }
    }
}