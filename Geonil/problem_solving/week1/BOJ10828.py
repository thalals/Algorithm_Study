import sys
In = sys.stdin.readline


class Stack:
    def __init__(self):
        self.top = -1
        self.stack = []

    def is_empty(self):
        if self.top == -1:
            return True
        else:
            return False

    def push_stack(self, data):
        self.stack.append(data)
        self.top += 1

    def pop_stack(self):
        if self.is_empty():
            return -1
        else:
            data = self.stack[self.top]
            del self.stack[self.top]
            self.top -= 1
            return data

    def get_size(self):
        return len(self.stack)

    def get_top(self):
        if self.is_empty():
            return -1
        else:
            return self.stack[self.top]


def main():
    num = int(In())
    stk = Stack()
    for _ in range(num):
        cmd = In().rstrip().split()
        if cmd[0] == 'push':
            stk.push_stack(int(cmd[1]))
        elif cmd[0] == 'pop':
            rlt = stk.pop_stack()
            print(rlt)
        elif cmd[0] == 'size':
            print(stk.get_size())
        elif cmd[0] == 'empty':
            if stk.is_empty():
                print(1)
            else:
                print(0)
        elif cmd[0] == 'top':
            print(stk.get_top())


main()
