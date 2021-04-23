
#include <cstdio>
#include <cstring>
#include <queue>
using namespace std;
#define pii pair<int,int>
int t, n, m, ans;
int arr[20][20];
int vis[20][20];
int d[22], p[22];
int dir[4][2] = {{0,1},{0,-1},{1,0},{-1,0}};
int max(int a, int b) {return a > b ? a : b;}
void bfs(int y, int x) {
    queue<pii> q;
    q.push(pii(y, x));
    vis[y][x] = 1;
    while(!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();

        if(vis[y][x] > n+1) return;
        if(arr[y][x]) d[vis[y][x]]++;
        for(int i=0; i<4; ++i) {
            int dy = y + dir[i][0];
            int dx = x + dir[i][1];
            if(dy>=0 && dx>=0 && dy<n && dx<n && !vis[dy][dx]) {
                q.push(pii(dy, dx));
                vis[dy][dx] = vis[y][x] + 1;
            }
        }
    }
}

int _get() {
    int ans = 0;
    int sum =0;
    for(int i=1; i<=n+1; ++i) {
        sum += d[i];
        if(p[i] <= sum*m)
            ans = sum;
    }
    return ans;
}

int main(int argc, char* argv[]) {
    scanf("%d", &t);

    for(int i=1; i<=21; ++i)
        p[i] = i*i + (i-1)*(i-1);

        scanf("%d %d", &n, &m);

        for(int i=0; i<n; ++i)
            for(int j=0; j<n; ++j)
                scanf("%d", &arr[i][j]);

        ans = 0;
        // for(int i=0; i<n; ++i)
            // for(int j=0; j<n; ++j) {
                bfs(0, 0);
                ans = max(ans, _get());
                // memset(d, 0, sizeof(d));
                // memset(vis, 0, sizeof(vis));
            // }

        printf("\n");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                printf("%d ", vis[i][j]);
            }
            printf("\n");
        }
        // printf("#%d %d\n", tc, ans);  
}


