#include <stdio.h>

int out1, out2, out3, out4 = 0;
int in1, in2, in3, in4 = 0;

int total, max = 0;

int main(void) {
	scanf("%d %d", &out1, &in1);
	scanf("%d %d", &out2, &in2);
	scanf("%d %d", &out3, &in3);
	scanf("%d %d", &out4, &in4);

	total = in1 - out1;

	if (total == 0 - out1) {
		max = in1;
		total = in1;
	}

	if (total + in2 - out2 > max) {
		total = total + in2 - out2;
		max = total;
	}

	if (total + in3 - out3 > max) {
		total = total + in3 - out3;
		max = total;
	}

	if (total + in4 - out4 > max) {
		total = total + in4 - out4;
		max = total;
	}
	printf("%d", max);
}