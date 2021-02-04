#include <stdio.h>
#define SIZE 50

char arr[SIZE][SIZE];
int b = 0, w = 0;

int main(void){
    int row, col;
    scanf("%d %d", &row, &col);

    for(int i = 0; i < col; i++){
        for(int j = 0; j < row; j++){
            scanf("%s", &arr[i][j]);
        }
    }
}

int colorCheck(int a, int b){
    for(int i = b; i < b + 8; i++){
        for(int j = a; j < a + 8; j++){
            
        }
    }
}