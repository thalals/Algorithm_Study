#include<iostream>
#include<list>
using namespace std;

int main() {
    string s; cin>>s;
    int M; cin>>M;
    list<char> result;

    for(int i=0; i<s.size(); i++) {
        result.push_back(s[i]);
    }    
    list<char>::iterator iter = result.end();

    for(int i=0; i<M; i++){
        char tmp; cin>>tmp;
        if(tmp=='P') {
            char input; cin>>input;
            result.insert(iter, input);
        }
        else if(tmp=='D') {
            if(iter!=result.end()){
                iter++;
            }
        }
        else if(tmp=='L') {
            if(iter!=result.begin()){
                iter--;
            }
        }
        else if(tmp=='B') {
            if(iter!=result.begin()){
                iter--;
                iter = result.erase(iter);
            }
        }
    }

    for(char i : result)
        cout<<i;
    return 0;
}