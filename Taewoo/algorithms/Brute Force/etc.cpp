#include<bits/stdc++.h>
using namespace std;

int main() {
    string arr[10] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    string s = "one4sevenone0";

    for(int i = 0; i < 10; i++) {
        while(s.find(arr[i]) != string::npos)
            s.replace(s.find(arr[i]), arr[i].size(), to_string(i));
    }
    cout << s << '\n';
}