#include <stdio.h>
#define SIZE 100

int shark[SIZE][SIZE];
int init = -1;
int total = 0;

typedef struct sharkpos{
    int r;
    int c;
} sharkPos;

typedef struct shark{
    sharkPos pos;
    int s;
    int d;
    int z;
} Shark;

int personMove();

int main(void){
    int x, y, cnt;
    scanf("%d %d %d", &x, &y, &cnt);

    shark[x][y];

    Shark arr[cnt];
    
    for(int i = 0; i < cnt; i++){
        scanf("%d %d %d %d %d", &arr[i].pos.r, &arr[i].pos.c, &arr[i].s, &arr[i].d, &arr[i].z);
    }
}


int personMove(){
    init++;
    return init;
}

int personScan(int cnt, int arr[]){
    for(int i = 0; i < cnt; i++){
        if(shark[i][init] == 1) total += arr[i];
    }
}