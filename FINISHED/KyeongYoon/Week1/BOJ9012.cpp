#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main(void) {
	int val;
	scanf("%d", &val);

	for (int i = 0; i < val; i++) {
		int cnt = 0;
		char bracket[50];
		scanf("%s", bracket);

		for (int j = 0; j < strlen(bracket); j++) {
			if (bracket[j] == '(') cnt++;
			else cnt--;
			if (cnt < 0) {			// (()))
				printf("NO\n");
				break;
			}
		}
		if (cnt == 0) printf("YES\n");
		else if (cnt > 0) printf("NO\n");
	}
}