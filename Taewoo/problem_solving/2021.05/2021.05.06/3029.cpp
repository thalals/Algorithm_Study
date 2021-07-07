#include <iostream>
using namespace std;
int now[3]; int throw_time[3];
int wait_time;
string get_answer() {
    string tmp = "";
    if(wait_time / 3600 < 10) tmp += "0";
    if(wait_time / 3600 >= 24) {
        int new_time = wait_time / 3600 - 24;
        if(new_time < 10) tmp += "0";
        tmp += to_string(new_time) + ":";
    }
    else {
        tmp += to_string(wait_time / 3600) + ":";
    }

    wait_time %= 3600;

    if(wait_time / 60 < 10) tmp += "0"; 
    
    tmp += to_string(wait_time / 60) + ":"; 
    wait_time %= 60; 
    
    if(wait_time < 10) tmp +="0"; 
    tmp += to_string(wait_time); 
    
    return tmp;
}

int main() {
    scanf("%d:%d:%d", &now[0], &now[1], &now[2]);
    scanf("%d:%d:%d", &throw_time[0], &throw_time[1], &throw_time[2]);

    int now_seconds = now[0] * 3600 + now[1] * 60 + now[2];
    int throw_seconds = throw_time[0] * 3600 + throw_time[1] * 60 + throw_time[2];

    if(now_seconds == throw_seconds) cout << "24:00:00";
    
    else {
        wait_time = 24 * 3600 - now_seconds + throw_seconds;
        cout << get_answer();
    }

}