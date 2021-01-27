import sys
In = sys.stdin.readline


class Stack:
    def __init__(self):
        self.top = -1
        self.stack = []

    def push(self, data):
        self.top += 1
        self.stack.append(data)

    def pop(self):
        data = self.stack[self.top]
        del self.stack[self.top]
        self.top -= 1
        return data

    def is_empty(self):
        if self.top == -1:
            return True
        else:
            return False


def check_VPS(ps):
    stk = Stack()

    for c in ps:
        if c == '(':
            stk.push(c)
        else:
            if stk.is_empty():
                return False
            else:
                data = stk.pop()
                if data != '(':
                    return False

    if stk.is_empty():
        return True
    else:
        return False


def main():
    num = int(In())
    parenthesis = []
    for _ in range(num):
        parenthesis.append(In().rstrip())

    for ps in parenthesis:
        if check_VPS(ps):
            print('YES')
        else:
            print('NO')


main()
