#include<iostream>
#include<algorithm>
using namespace std;

int main(){
    int a, b;
    int answer=-1e9;
    int total=0;
    for(int i=0; i<4; i++) {
        cin>>a>>b;
        total = total+b-a;
        answer= max(total, answer);
    }
    cout<<answer<<'\n';
}