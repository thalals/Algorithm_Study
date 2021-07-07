#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;
int n, k;
string s;
vector<int> number;

void convert() {
    int size = n / 4;
    for(int i = 0; i < n; i += size) {
        int sum = 0;
        for(int j = 0; j < size; j++) {
            if(s[i + j] >= '0' && s[i + j] <= '9') {
                sum += (s[i + j] - '0') * int(pow(16, size - j - 1));
            }
            else if(s[i + j] >= 'A' && s[i + j] <= 'F') {
                int tmp = (s[i + j] - 'A') + 10;
                sum += tmp * (int)pow(16, size - j - 1);
            }
        }
        number.push_back(sum);
    }
}

bool cmp(const int &a, const int &b){
    if(a > b) return true;
    return false;
}

void pro(int testcase) {
    convert();
    for(int i = 0; i < n / 4; i++) {
        rotate(s.begin(), s.begin() + s.size() - 1, s.end());
        convert();
    }
    sort(number.begin(), number.end(), cmp);
    number.erase(unique(number.begin(), number.end()), number.end());
    cout << '#' << testcase << ' ' << number[k - 1] << '\n';
}

void input() {
    int t; cin >> t;
    for(int tc = 1; tc <= t; tc++) {
        number.clear();
        cin >> n >> k;
        cin >> s;
        pro(tc);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    input();
    return 0;
}

// 2
// 12 10
// 1B3B3B81F75E
// 16 2
// F53586D76286B2D8