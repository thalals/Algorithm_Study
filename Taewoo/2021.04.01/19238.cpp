#include<bits/stdc++.h>
using namespace std;

struct TAXI {
    int x, y, fuel;
};
struct PERSON {
    int x, y, dist_x, dist_y;
};
struct INFO {
    int x, y, dist, person_number;
};
int n, m, l;
int _map[25][25];
int visited[25][25];
vector<PERSON> person;
TAXI taxi;
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};

bool cmp(const INFO &a, const INFO & b) {
    if(a.dist <= b.dist) {
        // 거리가 작은 순
        if(a.dist == b.dist) {
            if(a.x <= b.x) {
                // 행이 작은순
                if(a.x == b.x) {
                    if(a.y <= b.y) {
                        return true;
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }
    return false;
}

void input() {
    cin >> n >> m >> taxi.fuel;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> _map[i][j];
        }
    }
    int taxi_x, taxi_y; cin >> taxi_x >> taxi_y;
    taxi.x = --taxi_x; taxi.y = --taxi_y;
    for(int i = 0; i < m; i++) {
        int x, y, d_x, d_y; cin >> x >> y >> d_x >> d_y;
        --x, --y, --d_x, --d_y;
        person.push_back({x, y, d_x, d_y});
        _map[x][y] = i + 2;
    }
}

int find_person() {
    memset(visited, 0, sizeof(visited));
    queue<TAXI> q;
    q.push({taxi.x, taxi.y, taxi.fuel});
    visited[taxi.x][taxi.y] = 1;
    vector<INFO> candid;
    while(!q.empty()) {
        TAXI cap = q.front(); q.pop();

        if(cap.fuel == 0) continue;
        if(_map[cap.x][cap.y] > 1) {
            // 사람 도착
            candid.push_back({cap.x, cap.y, visited[cap.x][cap.y] - 1, _map[cap.x][cap.y]});
        }
        int f = --cap.fuel;
        for(int i = 0; i < 4; i++) {
            int nx = cap.x + dx[i];
            int ny = cap.y + dy[i];
            if(nx < 0 || nx == n || ny < 0 || ny == n || visited[nx][ny]) continue;
            if(_map[nx][ny] == 1) continue;
            visited[nx][ny] = visited[cap.x][cap.y] + 1;
            q.push({nx, ny, f});
        }
    }
    // 택시로 태울 수 없음.
    
    if(candid.size() == 0) return -1;
    sort(candid.begin(), candid.end(), cmp);
    _map[candid[0].x][candid[0].y] = 0;
    taxi.fuel = taxi.fuel - candid[0].dist;
    taxi.x = candid[0].x, taxi.y = candid[0].y;
    return candid[0].person_number;
}

bool go_dest(int dest_x, int dest_y) {
    memset(visited, 0, sizeof(visited));
    queue<TAXI> q;
    visited[taxi.x][taxi.y] = 1;
    q.push({taxi.x, taxi.y, taxi.fuel});

    while(!q.empty()) {
        TAXI cap = q.front(); q.pop();

        // 도착지점 도착 시
        if(cap.fuel == 0) return false;
        if(cap.x == dest_x && cap.y == dest_y) {
            taxi.fuel = taxi.fuel - visited[cap.x][cap.y] - 1;
            taxi.fuel = taxi.fuel + (visited[cap.x][cap.y] * 2);
            taxi.x = cap.x;
            taxi.y = cap.y;
            return true;
        }
        int f = --cap.fuel;
        for(int i = 0; i < 4; i++) {
            int nx = cap.x + dx[i];
            int ny = cap.y + dy[i];
            if(nx < 0 || nx == n || ny < 0 || ny == n || visited[nx][ny]) continue;
            if(_map[nx][ny] == 1) continue;
            visited[nx][ny] = visited[cap.x][cap.y] + 1;
            q.push({nx, ny, f});
        }
    }
    return false;
}

void pro() {
    for(int i = 0; i < m; i++) {
        int person_num = find_person();
        if(person_num == -1) {
            cout << -1;
            return;
        }
        bool flag = go_dest(person[person_num - 2].dist_x, person[person_num - 2].dist_y);
        if(flag == false) {
            cout << -1;
            return;
        }
    }
    cout << taxi.fuel;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    input();
    pro();
    return 0;
}