// BOJ2606 - DFS 컴퓨터 바이러스

#include <stdio.h>

int graph[1001][1001] = {0};
int DFSvisit[1001] = {0};

int cnt = 0;

void DFS(int, int);

int main(void){
    int n, m;
    int x, y;

    scanf("%d", &n);
    scanf("%d", &m);

    for(int i = 0; i < m; i++){
        scanf("%d %d", &x, &y);
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    DFS(1, n);

    printf("%d", cnt-1);

    return 0;
}

void DFS(int v, int n){
    int i;
    DFSvisit[v] = 1;
    cnt++;

    for(i = 1; i <= n; i++){
        if(graph[v][i] == 1 && DFSvisit[i] == 0) DFS(i, n);
    }
    return;
}