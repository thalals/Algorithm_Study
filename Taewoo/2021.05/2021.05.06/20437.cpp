#include <iostream>
#include <vector>
using namespace std;


int main() {
    int T;
    cin >> T;
    for(int i = 0; i < T; i++) {
        string str;
        cin >> str;

        vector<int> dict[26];
        int min_value = 1e9, max_value = -1e9;
        int K; cin >> K;

        for(int j = 0; j < str.size(); j++)
            dict[str[j] - 'a'].push_back(j);

        for(int j = 0; j < 26; j++) {
            if(dict[j].size() >= K) {
                int l = 0; int r = K - 1;

                int tmp1 = dict[j][r] - dict[j][l] + 1;
                int tmp2 = dict[j][r] - dict[j][l] + 1;
                while(r < dict[j].size() - 1) {
                    r++; l++;
                    tmp1 = min(dict[j][r] - dict[j][l] + 1, tmp1);
                    tmp2 = max(dict[j][r] - dict[j][l] + 1, tmp2);
                }
                min_value = min(tmp1, min_value);
                max_value = max(tmp2, max_value);
            }
        }

        if(min_value == 1e9 || max_value == -1e9)
            cout << -1 << "\n";
        else
            cout << min_value << " " << max_value << "\n";
    }
}