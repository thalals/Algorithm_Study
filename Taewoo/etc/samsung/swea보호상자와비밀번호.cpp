#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int n, k;
string s;
vector<int> number;
void get_num() {
    // 문자 -> 숫자로 변환
    int temp[28];
    for(int i = 0; i < n; i++) {
        if(s[i] >= '0' && s[i] <= '9')
            temp[i] = s[i] - '0';
        else if(s[i] >= 'A' && s[i] <= 'F')
            temp[i] = s[i] - 'A' + 10;
    }

    for(int i = 0; i < n; i++)
        cout << temp[i] << ' ';
    cout << '\n';

    // int box[4];
    // int idx = 0;
    // fill(box, box + 4, 0);
    // for(int i = 0; i < 4; i++) {
    //     for(int j = 0; j < n/4; j++) {
    //         box[i] = box[i] * 16 + temp[idx++];
            
    //     }
    //     number.push_back(box[i]);
    // }
}

void rotate_() {
    char tmp = s[n - 1];
    for(int i = n - 1; i > 0; i--) {
        s[i] = s[i - 1];
    }
    s[0] = tmp;
}

void pro(int testcase) {
    for(int i = 0; i < n/4; i++) {
        // 문자 -> 숫자로 변환
        get_num();

        // 회전
        // rotate_();
    }
    // sort(number.begin(), number.end());
    // number.erase(unique(number.begin(), number.end()), number.end());
    // cout << '#' << testcase << ' ' << number[number.size() - k] << '\n';
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    int T; cin >> T;
    for(int tc = 1; tc <= T; tc++) {
        cin >> n >> k;
        cin >> s;
        pro(tc);
    }
}