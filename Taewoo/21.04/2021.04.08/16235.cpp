/*
Comment : 시간초과 발생...
          
*/
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;

/*
    1. 봄에, 나무가 자신의 나이만큼 양분을 먹고, 나이가 +1
        2. 하나의 칸에 나무가 여러 개 있다면, 나이가 어린 나무부터 양분을 먹는다.
        3. 양분이 부족해 자신의 나이만큼 양분을 못먹으면 죽는다.
    4. 여름에, 죽은 나무가 양분으로 변한다. 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가. 소수점은 버리기
    5. 가을에, 나무가 번식하며, 번식하는 나무는 나이가 5의 배수여야 함.
        6. 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
    7. 겨울에, S2D2가 땅을 돌아다니면서 땅에 양분을 추가하기,
    8. 그러면, K년 후 살아있는 나무의 개수는 ??
*/
int n, m, k;
int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
vector<int> _map[11][11]; // 나무 나이
int energy[11][11]; // 나무 양분
int add_energy[11][11]; // 추가되는 양분의 양
vector<int> dead_energy[11][11];
void input() {
    cin >> n >> m >> k;
    
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            cin >> add_energy[i][j];
            energy[i][j] = 5;
        }
    }

    for(int i = 0; i < m; i++) { 
        int x, y, z;
        cin >> x >> y >> z;
        _map[x][y].push_back(z);
    }
};

void spring() {
    /*
     1. 봄에, 나무가 자신의 나이만큼 양분을 먹고, 나이가 +1
        2. 하나의 칸에 나무가 여러 개 있다면, 나이가 어린 나무부터 양분을 먹는다.
        3. 양분이 부족해 자신의 나이만큼 양분을 못먹으면 죽는다.
    */
   for(int i = 1; i <= n; i++) {
       for(int j = 1; j <= n; j++) {
           if(_map[i][j].size() == 0) continue;

           sort(_map[i][j].begin(), _map[i][j].end());
           vector<int> tmp;
           int dead_tree = 0;
            for(int k = 0; k < _map[i][j].size(); k++) {
                int tree_age = _map[i][j][k]; // 가장 나이가 어린 나무
                if(energy[i][j] >= tree_age) {
                    energy[i][j] -= tree_age;
                    tmp.push_back(tree_age + 1);
                }
                else {
                    // dead_energy[i][j].push_back(tree_age);
                    dead_tree += (tree_age / 2);
                }
            }
            _map[i][j].clear();
            for(int k = 0; k < tmp.size(); k++) {
                _map[i][j].push_back(tmp[k]);
            }
            energy[i][j] += dead_tree;
       }
   }
}

void summer() {
    /*
     4. 여름에, 죽은 나무가 양분으로 변한다. 죽은 나무마다 
        나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가. 소수점은 버리기
    */
   for(int i = 1; i <= n; i++) {
       for(int j = 1; j <= n; j++) {
           for(int k = 0; k < dead_energy[i][j].size(); k++) {
               energy[i][j] += (dead_energy[i][j][k] / 2);
           }
       }
   }
}

void fall() {
    /*
        가을에, 나무가 번식하며, 번식하는 나무는 나이가 5의 배수여야 함.
        6. 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
    */
   for(int i = 1; i <= n; i++) {
       for(int j = 1; j <= n; j++) {
           if(_map[i][j].size() == 0) continue;
           for(int k = 0; k < _map[i][j].size(); k++) {
               int tree_age = _map[i][j][k];
               if(tree_age % 5 == 0) {
                   for(int d = 0; d < 8; d++) {
                       int nx = i + dx[d];
                       int ny = j + dy[d];
                       if(nx < 1 || ny < 1 || nx > n || ny > n) continue;
                        _map[nx][ny].push_back(1);
                       
                   }
               }
           }
       }
   }
};

void winter() {
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            energy[i][j] += add_energy[i][j];
        }
    }
}

void pro() {
    for(int i = 0; i < k; i++) {
        spring();
        // summer();
        fall();
        winter();
    }
    
    int answer = 0;
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            answer += _map[i][j].size();
        }
    }
    cout << answer;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    input();
    pro();
    return 0;
}