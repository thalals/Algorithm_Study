#include <iostream>
typedef long long int ll;
using namespace std;

int visited[26][26];
int _map[26][26];
int n, m;
void input() {
	cin >> n >> m;
}

void go(int count, int k) {
	if(k == count) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++){
				cout << _map[i][j] << ' ';
			}
			cout << '\n';
		}
		cout << '\n';
	}
	
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < m; j++) {
			if(visited[i][j]) continue;
			visited[i][j] = 1;
			_map[i][j] = 1;
			go(count, k + 1);
			visited[i][j] = 0;
			_map[i][j] = 0;
		}
	}
}
int main() {
	ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	input();
	for(int i = 0; i <= n * m; i++) {
		memset(visited, 0 , sizeof(visited));
		go(i, 0);
	}
	return 0;
}
