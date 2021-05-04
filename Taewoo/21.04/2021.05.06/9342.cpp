#include <iostream>
using namespace std;

int n;
int main() {
    cin >> n;
    for(int i = 0; i < n; i++) {
        string s;
        cin >> s;
        int size = s.size();
        bool flag = false;
        
        if(s[0] == 'A' || s[0] == 'B' || s[0] == 'C' || s[0] == 'D' || s[0] == 'E' || s[0] == 'F') {
            flag = true;
        }
        if(!flag) {
            cout << "Good" << "\n";
            continue;
        }

        flag = false;
        if (s[size - 1] == 'A' || s[size - 1] == 'B' || s[size - 1] == 'C' || s[size - 1] == 'D' || s[size - 1] == 'E' || s[size - 1] == 'F')
			flag = true;
		if (!flag) {
			cout << "Good" << "\n";
			continue;
		}

        char previous = 'a';

		for (int j = 1; j < s.size() - 1; j++) {
			
			if (s[j - 1] != s[j]) {

				if (s[j - 1] == 'B' || s[j - 1] == 'D' || s[j - 1] == 'E') {

					if (previous == 'a' && s[j] == 'A') {
						previous = 'A';
					}
					else {
						flag = false;
						cout << "Good" << "\n";
						break;
					}

				}
                else if (s[j - 1] == 'A') {

					if ((previous == 'a' || previous == 'A') && s[j] == 'F') {
						previous = 'F';
					}
					else {
						flag = false;
						cout << "Good" << "\n";
						break;
					}

				}
				else if (s[j - 1] == 'F') {

					if (previous == 'F' && s[j] == 'C') {
						previous = 'C';
					}
					else {
						flag = false;
						cout << "Good" << "\n";
						break;
					}

				}
				else if (s[j - 1] == 'C') {

					if (previous == 'C' && (s[j] == 'A' || s[j] == 'B' || s[j] == 'C' || s[j] == 'D' || s[j] == 'E' || s[j] == 'F')) {
					}
					else {
						flag = false;
						cout << "Good" << "\n";
						break;
					}

				}
				else {
					flag = false;
					cout << "Good" << "\n";
					break;
				}
			}
		}

		if (flag)
			cout << "Infected!" << "\n";

    }
}