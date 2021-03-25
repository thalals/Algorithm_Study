#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

const int MAX = 15;

int N, M, D;
int arr[MAX][MAX];
int copyArr[MAX][MAX];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N >> M >> D;

	vector<pair<int, int>> enemy;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cin >> arr[i][j];

			if (arr[i][j] == 1)
			{
				// 적들의 좌표를 모두 넣어준다
				enemy.push_back({ i, j });
			}
		}
	}

	/*
		next_permutation을 이용할 것이기 때문에
		00..0111 부터 시작
	*/
	vector<int> archer;
	for (int i = 0; i < M - 3; i++)
	{
		archer.push_back(0);
	}

	for (int i = 0; i < 3; i++)
	{
		archer.push_back(1);
	}

	int result = 0;
	do
	{
		int cnt = 0;
		// 적들의 좌표를 복사
		vector<pair<int, int>> temp = enemy;

		vector<int> v;
		for (int i = 0; i < archer.size(); i++)
		{
			if (archer[i] == 1)
			{
				// 현재 궁수 위치 저장
				v.push_back(i);
			}
		}

		while (!temp.empty())
		{
			vector<int> target;

			// 궁수는 동시에 공격
			for (int i = 0; i < v.size(); i++)
			{
				int y = N; int x = v[i];
				int idx = 0;
				int enemyX = temp[0].second; // 적의 위치
				int dist = abs(y - temp[0].first) + abs(x - temp[0].second);
				for (int j = 1; j < temp.size(); j++)
				{
					int tempDist = abs(y - temp[j].first) + abs(x - temp[j].second);
					
					// 더 가까운 적
					if (dist > tempDist)
					{
						enemyX = temp[j].second;
						dist = tempDist;
						idx = j;
					}
					// 거리가 같다면 더 왼쪽에 있는 적
					else if (dist == tempDist && enemyX > temp[j].second)
					{
						enemyX = temp[j].second;
						idx = j;
					}
				}

				// D 이내에 있는 적만 처치 가능
				if (dist <= D)
				{
					target.push_back(idx);
				}
			}

			// 동시에 공격하기 때문에 중복된 적 있을 수 있다
			target.erase(unique(target.begin(), target.end()), target.end());
			sort(target.begin(), target.end());
			int shoot = 0;
			// 적을 처치
			for (int i = 0; i < target.size(); i++)
			{
				temp.erase(temp.begin() + (target[i] - shoot++));
				cnt++;
			}

			if (temp.empty())
			{
				break;
			}

			// 한칸 아래로
			vector<pair<int, int>> copyTemp;
			for (int i = 0; i < temp.size(); i++)
			{
				if (temp[i].first < N - 1)
				{
					copyTemp.push_back({ temp[i].first + 1, temp[i].second });
				}
			}

			temp = copyTemp;
		}

		result = max(result, cnt);
	} while (next_permutation(archer.begin(), archer.end()));

	cout << result << "\n";
	return 0;
}