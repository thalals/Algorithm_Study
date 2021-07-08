'''
problem : 풍선 터뜨리기 (BOJ 2504)
comment : 
'''
import sys
In = sys.stdin.readline


class Bracket(object):
    def __init__(self):
        self.stack = []
        self.top = -1

    def is_empty(self):
        if self.stack:
            return False
        return True

    def push(self, x):
        self.stack.append(x)
        self.top += 1

    def pop(self):
        if self.is_empty():
            return 0
        self.top -= 1
        return self.stack.pop()

    def peek(self):
        if self.is_empty():
            return 0
        return self.stack[self.top]

    def match(self, left, right):
        if left == '(' and right == ')':
            return 2
        elif left == '[' and right == ']':
            return 3
        else:
            return 0

    def calculate(self, brackets):
        answer = 0
        inner = 0
        subset = 0
        flag = True
        depth = 0

        # string with brackets
        for b in brackets:
            if b == '(' or b == '[':
                depth += 1
                if not flag:
                    flag = True
                    if self.stack:
                        inner += subset
                        subset = 0
                    else:
                        answer += inner
                self.push(b)
            else:
                depth -= 1
                compare = self.pop()
                if compare == 0:
                    return 0

                if flag:
                    # first close
                    flag = False
                    subset = self.match(compare, b)
                else:
                    subset *= self.match(compare, b)

                if subset == 0:
                    return 0

        if self.stack:
            return 0

        return answer


def main():
    bracket_string = list(map(str, In().rstrip()))
    bracekts = Bracket()
    print(bracekts.calculate(bracket_string))


if __name__ == "__main__":
    main()
