#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

#define STACK_SIZE 100001

int stack[STACK_SIZE];
int stack_top = -1;

int empty();
void push(int);
int pop();
int top();
int size();

int main(void) {
	int init;

	scanf("%d", &init);

	for (int i = 0; i < init; i++) {
		char func[7];
		scanf("%s", func);

		if (!strcmp(func, "push")) {
			int val;
			scanf("%d", &val);
			push(val);
		}
		else if (!strcmp(func, "pop")) printf("%d\n", pop());
		else if (!strcmp(func, "top")) printf("%d\n", top());
		else if (!strcmp(func, "size")) printf("%d\n", size());
		else if (!strcmp(func, "empty")) printf("%d\n", empty());
	}
	return 0;
}

int empty() {
	if (stack_top == -1) return 1;
	else return 0;
}

void push(int x) {
	stack[++stack_top] = x;
}

int pop() {
	if (empty()) return -1;
	else return stack[stack_top--];
}

int top() {
	if (empty()) return -1;
	else return stack[stack_top];
}

int size() {
	return stack_top + 1;
}