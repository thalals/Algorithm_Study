// BOJ1260 - DFS, BFS
#include <stdio.h>

int graph[1001][1001] = {0};
int DFSvisit[1001] = {0};
int BFSvisit[1001] = {0};
int queue[1001];

void DFS(int, int);
void BFS(int, int);

int main(void){
    int n, m, start;
    int x, y;

    scanf("%d %d %d", &n, &m, &start);

    for(int i = 0; i < m; i++){
        scanf("%d %d", &x, &y);
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    DFS(start, n);
    printf("\n");
    BFS(start, n);

    return 0;
}

void DFS(int v, int n){
    int i;
    DFSvisit[v] = 1;
    printf("%d ", v);

    for(i = 1; i <= n; i++){
        if(graph[v][i] == 1 && DFSvisit[i] == 0) DFS(i, n);
    }
    return;
}

void BFS(int v, int n){
    int front = 0, rear = 0;
    int pop, i;
    printf("%d ", v);

    queue[0] = v;
    rear++;
    BFSvisit[v] = 1;

    while(front < rear){
        pop = queue[front];
        front++;

        for(i = 1; i <= n; i++){
            if(graph[pop][i] == 1 && BFSvisit[i] == 0){
                printf("%d ", i);
                queue[rear] = i;
                rear++;
                BFSvisit[i] = 1;
            }
        }
    }
    return;
}