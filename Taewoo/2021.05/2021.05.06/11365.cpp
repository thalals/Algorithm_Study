#include <iostream>
using namespace std;

int main() {

    while(1) {
        string s;
        getline(cin, s);

        if(s == "END") break;
        for(int i = s.size() -1; i >= 0; i--) {
            cout << s[i];
        }
        cout << '\n';
    }
}