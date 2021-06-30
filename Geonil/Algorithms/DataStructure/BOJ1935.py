'''
problem : 후위표기식2 문제 (BOJ 1935)
comment : stack 이용, 알파벳이면 push 연산자면 2개pop해서 연산후 push
'''
import sys
from collections import defaultdict
In = sys.stdin.readline


class PostfixCalculator:
    def __init__(self):
        self.stack = []
        self.d_dict = defaultdict(int)

    def calculate(self, expression, numbers):
        n = 0
        for c in expression:
            if c.isalpha():
                if not self.d_dict[c]:
                    self.d_dict[c] = numbers[n]
                    n += 1
                self.stack.append(self.d_dict[c])
            else:
                b, a = self.stack.pop(), self.stack.pop()
                if c == '+':
                    self.stack.append(a+b)
                elif c == '-':
                    self.stack.append(a-b)
                elif c == '*':
                    self.stack.append(a*b)
                elif c == '/':
                    self.stack.append(a/b)

        return self.stack.pop()


def main():
    n = int(In())
    exp = In().rstrip()
    numbers = []
    for _ in range(n):
        numbers.append(int(In()))

    postfix = PostfixCalculator()
    answer = postfix.calculate(exp, numbers)
    print(f'{answer:.2f}')


if __name__ == "__main__":
    main()
