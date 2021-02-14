/*
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
더 이상 방문할 수 있는 점이 없는 경우 종료한다. 
정점 번호는 1번부터 N번까지이다.

첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 
탐색을 시작할 정점의 번호 V가 주어진다. 
다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
입력으로 주어지는 간선은 양방향이다.

5 5 3
5 4
5 2
1 2
3 4
3 1

3 1 4 2 5

4 5 1
1 2
1 3
1 4
2 4
3 4

1 2 3 4
*/

#include <stdio.h>

struct queue
{
    int spot;
    s int edge;
    int start;
};

int main()
{
    queue q[1000];
    int graph[1000][1000];

    scanf("%d %d %d", &spot, &line, &start);

    for (int i = 0; i < spot; i++)
    {
        for (int j = 0; j < line; j++)
        {
            scanf("%d %d", &);
        }
    }
    return 0;
}

int put(int spot)
{
    int queue[spot];
}