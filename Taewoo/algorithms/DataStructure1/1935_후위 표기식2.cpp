/*
Problem : https://www.acmicpc.net/problem/1874
Comment : 큐를 이용해서 한번 뺴고 버리고, 한번 뺴고 큐에 다시 넣고...하나만 남을 때까지
*/
#include <bits/stdc++.h>
#define MAX 100000
using namespace std;

int N;
double num;
string s;
vector<int> vec;
void input() {
    cin >> N;
    cin >> s;
    for(int i = 0; i < N; i++) {
        cin >> num;
        vec.push_back(num);
    }
}
stack<double> stk;
void calc(double num1, double num2, char operation) {
    if(operation == '+') stk.push(num2 + num1);
    else if(operation =='-') stk.push(num2 - num1);
    else if(operation == '*') stk.push(num2 * num1);
    else stk.push(num2 / num1);
}

void pro() {
    for(int i = 0; i < s.size(); i++) {
        if(s[i] >= 'A' && s[i] <= 'Z') stk.push(vec[s[i] - 'A']);
        else {
            double num1 = stk.top();
            stk.pop();
            double num2 = stk.top();
            stk.pop();
            calc(num1, num2, s[i]);
        }
    }
    cout << fixed;
    cout.precision(2);
    cout << stk.top();
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    pro();
    return 0;
}