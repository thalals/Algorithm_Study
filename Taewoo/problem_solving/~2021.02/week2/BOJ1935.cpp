#include<iostream>
#include<vector>
#include<stack>
using namespace std;
vector<int> vec;
stack<double> stk;

void calc(double num1, double num2, char oper) {
    if(oper == '+') stk.push(num2+num1);
    else if(oper =='-') stk.push(num2-num1);
    else if(oper =='*') stk.push(num2*num1);
    else stk.push(num2/num1);
}

int main() {
    int N; cin>>N;
    string s; cin>>s;

    for(int i=0; i<N; i++) {
        double num; cin>>num;
        vec.push_back(num);
    }
    for(int i=0; i<s.size(); i++) {
        if(s[i]>='A' && s[i]<='Z') { // 숫자
            stk.push(vec[s[i]-'A']);
        }
        else { // 연산자
            double num1 = stk.top(); stk.pop();
            double num2 = stk.top(); stk.pop();
            calc(num1, num2, s[i]);
        }
    }
    cout<<fixed;
    cout.precision(2);
    cout<<stk.top();
    return 0;
}