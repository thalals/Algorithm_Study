// BOJ2615 오목
#include <stdio.h>
#define SIZE 19

int arr[SIZE][SIZE] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 2, 0, 0, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 1, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 0, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
int findRow = 0;
int findCol = 0;
int cnt = 0;                            // 바둑알 이어진 갯수 확인 카운트
int winFlag = 0;

int findStart();
int check();
void rightCheck(int, int);
void bottomCheck(int, int);
void crossCheck(int, int);

int main(void){
    /* for(int i = 0; i < SIZE; i++){
        for(int j = 0; j < SIZE; j++){
            scanf("%d", &arr[i][j]);
        }
    } */

    printf("%d", findStart());
}

// 1 - black, 2 - white

int findStart(){
    if(findRow > 18 && findCol > 18) return 0;
    while(arr[findRow][findCol] == 0){
        findCol++;
        if(findCol == SIZE){
            findCol = 0;
            findRow++;
        }
    }
    //printf("%d %d\n", findRow, findCol);
    check();
}

int check(){
    int checkRow, checkCol;
    checkRow = findRow;
    checkCol = findCol;

    if(arr[checkRow][checkCol] == 1){
        printf("1check %d %d\n", checkRow, checkCol);
        rightCheck(checkRow, checkCol);
        bottomCheck(checkRow, checkCol);
        crossCheck(checkRow, checkCol);
        printf("cross end end\n");
        if(winFlag == 1) return 1;
    }

    else if(arr[checkRow][checkCol] == 2){
        printf("2check %d %d\n", checkRow, checkCol);
        rightCheck(checkRow, checkCol);
        bottomCheck(checkRow, checkCol);
        printf("cross start\n");
        crossCheck(checkRow, checkCol);
        printf("cross end end\n");
        if(winFlag == 1) return 2;
    }
    if(findCol == SIZE) findRow++;
    else findCol++;

    findStart();
}

void rightCheck(int row, int col){
    while(arr[row][col] == arr[row][col+1] && winFlag == 0){
        printf("right cnt : %d\n", cnt);
        cnt++;
        row += 1;
        col += 1;
        rightCheck(row, col);
    }
    if(cnt == 4) winFlag = 1;
    else cnt = 0;
}

void bottomCheck(int row, int col){
    while(arr[row][col] == arr[row+1][col] && winFlag == 0){
        printf("bottom cnt : %d\n", cnt);
        cnt++;
        row += 1;
        col += 1;
        bottomCheck(row, col);
    }
    if(cnt == 4) winFlag = 1;
    else cnt = 0;
}

void crossCheck(int row, int col){
    while(arr[row][col] == arr[row+1][col+1] && winFlag == 0){
        cnt++;
        printf("cross cnt : %d\n", cnt);
        printf("%d %d\n", row, col);
        row += 1;
        col += 1;
        printf("%d %d\n", row, col);
        crossCheck(row, col);
    }
    printf("cross end\n");
    printf("end %d %d\n", row, col);
    if(cnt == 4){
        winFlag = 1;
        printf("win\n");
        }   
    else{
        cnt = 0;
        printf("lose\n");                   // 여기서 왜 안 빠져나옴..
    }
}