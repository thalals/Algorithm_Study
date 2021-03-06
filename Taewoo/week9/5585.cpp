/**
 * Problem: 거스름돈 (5585)
 * 타로는 자주 JOI잡화점에서 물건을 산다. JOI잡화점에는 잔돈으로 500엔, 100엔, 50엔, 10엔, 5엔, 1엔이 충분히 있고, 
 * 언제나 거스름돈 개수가 가장 적게 잔돈을 준다. 타로가 JOI잡화점에서 물건을 사고 카운터에서 1000엔 지폐를 한장 냈을 때,
 * 받을 잔돈에 포함된 잔돈의 개수를 구하는 프로그램을 작성하시오.
 */

#include <bits/stdc++.h>

using namespace std;
int main() {
    int money[6] = {500, 100, 50, 10, 5, 1};
    int pay, change, count = 0;
    cin >> pay;
    change = 1000 - pay;
    for(int i = 0; i < 6; i++) {
        while(change >= money[i]) {
            change -=money[i];
            count++;
            if(change == 0) break;
        }
    }
    cout << count;
}