#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

//  각각의 방향  ↑, ↖,  ←,   ↙, ↓, ↘, →,  ↗
int dx[] = {0, -1, -1, 0, 1, 1, 1, 0, -1};
int dy[] = {0, 0, -1, -1, -1, 0, 1, 1, 1};
int n;

vector<pair<int, int> > given_blocks;
vector<int> undicided_indices;
int next_dir[9][8];
int max_score = 0;
int bucket[101][5];
int temp[101][5];

void print() {
    cout << '\n';
    for(int i = 0; i <= n; i++) {
        for(int j = 1; j <= 4; j++) {
            cout << bucket[i][j] << ' ';
        }
        cout << '\n';
    }
    cout << '\n';
}

void dropOneBlock(int block_type, int drop_idx) {
    for(int i = n; i >= 0; i--) {
        if(bucket[i][drop_idx] == 0) {
            bucket[i][drop_idx] = block_type;
            break;
        }
    }
}

int bomb() {
    int score = 0;
    for(int i = 0; i <= n; i++)
        if(bucket[i][1] && bucket[i][2] && bucket[i][3] && bucket[i][4]) {
            bucket[i][1] = bucket[i][2] = bucket[i][3] = bucket[i][4] = 0;
            score += 1;
        }
    
    return score;
}

void gravity() {
    for(int i = 1; i <= 4; i++) {
        while(1) {
            bool isOk = false;
            for(int j = n; j >= 0; j--) {
                if(bucket[j][i] == 0 && bucket[j - 1][i] != 0) {
                    bucket[j][i] = bucket[j - 1][i];
                    bucket[j - 1][i] = 0;
                    isOk = true;
                }
            }
            if(!isOk) break;
        }
    }
    // for(int i = 0; i <= n; i++)
    //     for(int j = 1; j <= 4; j++)
    //         temp[i][j] = 0;

    // for(int j = 1; j <= 4; j++) {
    //     int last_idx = n;
    //     for(int i = n; i >= 0; i--)
    //         if(bucket[i][j])
    //             temp[last_idx--][j] = bucket[i][j];
    // }

    // for(int i = 0; i <= n; i++)
    //     for(int j = 1; j <= 4; j++)
    //         bucket[i][j] = temp[i][j];
}

void update(int x, int y, int block_type) {
    if(temp[x][y] == 0 || temp[x][y] > block_type)
        temp[x][y] = block_type;
}

void move() {
    for(int i = 0; i <= n; i++) 
        for(int j = 1; j <= 4; j++)
            temp[i][j] = 0;

    for(int i = 0; i <= n; i++) {
        for(int j = 1; j <= 4; j++) {
            if(!bucket[i][j]) continue;

            int block_type = bucket[i][j];

            for(int k = 0; k < 8; k++) {
                int dir = next_dir[block_type][k];
                int nx = i + dx[dir];
                int ny = j + dy[dir];

                if(0 <= nx && nx <= n && 1 <= ny && ny <= 4) {
                    update(nx, ny, block_type);
                    break;
                }
            }
        }
    }

    for(int i = 0; i <= n; i++) 
        for(int j = 1; j <= 4; j++)
            bucket[i][j] = temp[i][j];

}

int Score() {

    int curr_score = 0;

    for(int i = 0; i <= n; i++)
        for(int j = 1; j <= 4; j++)
            bucket[i][j] = 0;
    
    for(int i = 0; i < n; i++) {
        int block_type = given_blocks[i].first;
        int drop_idx = given_blocks[i].second;

        // 해당 위치에 블록을 떨어뜨리고, 점수를 얻을 수 있는지 확인하기
        dropOneBlock(block_type, drop_idx);
        curr_score += bomb();
        gravity();
    
    
        move();
        // print();
        gravity();

        curr_score += bomb();
        gravity();
    }
    return curr_score;
}

void findMaxScore(int cnt) {
    if(cnt == undicided_indices.size()) {
        max_score= max(max_score, Score());
        return;
    }
    for(int i = 1; i <= 4; i++) {
        given_blocks[undicided_indices[cnt]].second = i;
        findMaxScore(cnt + 1);
        given_blocks[undicided_indices[cnt]].second = 0;
    }
}

int main() {
    cin >> n;

    for(int i = 1; i <= 8; i++) for(int j = 0; j < 8; j++) cin >> next_dir[i][j];

    for(int i = 0; i < n; i++) {
        int k, c; cin >> k >> c;
        given_blocks.push_back(make_pair(k, c));
        if(c == 0) undicided_indices.push_back(i);
    }

    findMaxScore(0);
    cout << max_score << '\n';
    return 0;
}