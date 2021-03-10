#include <stdio.h>
#define SIZE 5

int arr[SIZE][SIZE];
int max = 0, temp = 0;

int compare(int t);
int rightDown(int i, int j);
int leftDown(int i, int j);
int rightUp(int i, int j);
int leftUp(int i, int j);

int main(void){
    int N, M;
    int K;
    scanf("%d %d", &N, &M);

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            scanf("%d", &K);
            arr[i][j] = K;
        }
    }

    if(2 <= N && 2 <= M){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(i == 0){
                    if(j == 0) max = compare(rightDown(i, j));
                    else if(1 <= j && j < M-1){ max = compare(rightDown(i, j)); max = compare(leftDown(i, j)); }
                    else if(j == M-1) max = compare(leftDown(i, j));
                }
                else if(1 <= i && i < N-1){
                    if(j == 0){ max = compare(rightDown(i, j)); max = compare(rightUp(i, j)); }
                    else if(1 <= j && j < M-1){ max = compare(rightDown(i, j)); max = compare(leftDown(i, j)); max = compare(rightUp(i, j)); max = compare(leftUp(i, j)); }
                    else if(j == M-1){ max = compare(leftDown(i, j)); max = compare(leftUp(i, j)); }
                }
                else if(i == N-1){
                    if(j == 0) max = compare(rightUp(i, j));
                    else if(1 <= j && j < M-1){ max = compare(rightUp(i, j)); max = compare(leftUp(i, j)); }
                    else if(j == M-1) max = compare(leftUp(i, j));
                }
            }
        }
        printf("%d", max);
    }
    else printf("0");
}

int compare(int t){
    if(t > max) return t;
    else return max;
}

int rightDown(int i, int j){
    temp = (arr[i][j] * 2) + arr[i+1][j] + arr[i][j+1];
    return temp;
}

int leftDown(int i, int j){
    temp = (arr[i][j] * 2) + arr[i+1][j] + arr[i][j-1];
    return temp;
}

int rightUp(int i, int j){
    temp = (arr[i][j] * 2) + arr[i-1][j] + arr[i][j+1];
    return temp;
}

int leftUp(int i, int j){
    temp = (arr[i][j] * 2) + arr[i-1][j] + arr[i][j-1];
    return temp;
}