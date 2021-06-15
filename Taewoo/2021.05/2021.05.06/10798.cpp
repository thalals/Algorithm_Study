#include <iostream>
using namespace std;
int main() {
    string word[5];
    
    for(int i = 0; i < 5; i++)
        cin >> word[i];

    for(int i = 0; i < 15; i++) {
        for(int j = 0; j < 5; j++) {
            if(i < word[j].size())
                cout << word[j][i];
        }
    }
}