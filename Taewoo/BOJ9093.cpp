#include<iostream>
#include<algorithm>
using namespace std;

int main() {
    int T; cin>>T;
    string s;
    cin.ignore();
    while(T--) {
        getline(cin ,s);
        int prevIdx = 0;
        for(int i=0; i<s.size(); i++){
            if(s[i]==' '){
                string tmp = s.substr(prevIdx, i-prevIdx);
                reverse(tmp.begin(), tmp.end());
                cout<<tmp<<' ';
                prevIdx = i+1;
            }
        }
        string last = s.substr(prevIdx);
        reverse(last.begin(), last.end());
        cout<<last<<'\n';
    }

    return 0;
}