#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

char stack[1001];
int stack_top = -1;

void push(char);
int pop();

int main(void) {
	int cnt;
	scanf_s("%d%*c", &cnt);

	for (int i = 0; i < cnt; i++) {
		gets_s(stack);
		for (int j = 0; j < strlen(stack); j++) {
			push(stack[j]);
			if (stack[j] == ' ') {
				pop();
				for (int k = 0; k < j; k++) {
					printf("%c", pop());
				}
				printf(" ");
			}
			else if (stack[j+1] == NULL) {
				for (int k = 0; k < j; k++) {
					printf("%c", pop());
				}
			}
		}
		printf("\n");
	}
	return 0;
}

void push(char x) {
	stack[++stack_top] = x;
}

int pop() {
	return stack[stack_top--];
}