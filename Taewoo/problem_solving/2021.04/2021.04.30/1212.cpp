#include <iostream>
#include <algorithm>
using namespace std;

string get_number(char c) {
    string result = "";
    int num = c - '0';

    if(num == 0)
        return "0";
    
    while(num != 0) {
        result += to_string(num % 2);
        num /= 2;
    }
    reverse(result.begin(), result.end());
    return result;
}

int main() {
    string s;
    cin >> s;
    for(int i = 0; i < s.size(); i++) {
        if(i == 0) {
            cout << get_number(s[i]);
        }
        else {
            string temp = get_number(s[i]);
            while(temp.size() != 3) temp = '0' + temp;
            cout << temp;
        }
    }    
}