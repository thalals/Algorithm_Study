#include <stdio.h>
#include <string.h>

#define SIZE 10001

char arr[SIZE];
int cnt_arr[SIZE];

int cnt;
int max = 0;
int mode_num;

float avg();
int median();
int mode();
int maxmin();

int main(void){
    int num;
    scanf("%d", &cnt);

    for(int i = 0; i < cnt; i++){
        scanf("%d", &num);
        cnt_arr[num]++;
    }

    int k = 0;

    for(int i = 0; i <= SIZE; i++){
        int num = 0;
        if(cnt_arr[i] == 0) continue;

        for(int j = 0; j < cnt_arr[i]; j++){
            i = arr[k];
            k++;
            num++;
        }
        if(num > max){
            max = num;
            mode_num = k;
        }
    }

    printf("%.0f\n", avg());
    printf("%d", median());
    printf("%d", mode());
    printf("%d", maxmin());
}

float avg(){
    float total;

    for(int i = 0; i < cnt; i++){
        total += arr[i];
    }
    return total/cnt;
}

int median(){
    return arr[((1+cnt)/2)-1];
}

int mode(){
    return arr[mode_num];
}

int maxmin(){
    return arr[cnt-1] - arr[0];
}