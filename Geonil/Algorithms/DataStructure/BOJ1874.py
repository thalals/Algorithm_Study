'''
problem : 스택 수열 (BOJ 1874)
comment : 
'''
import sys
In = sys.stdin.readline

num = int(In())


class Sequence:
    def __init__(self, num):
        self.stack = []
        self.num = num
        self.now = 1
        self.sequences = []

    def push(self, x):
        self.stack.append(x)
        self.sequences.append('+')

    def pop(self):
        self.sequences.append('-')
        self.stack.pop()

    def find(self, x):
        now = self.now

        while now <= x:
            self.push(now)
            now += 1

        while True:
            if self.stack[-1] == x:
                self.pop()
                break
            else:
                return False

        self.now = now
        return True

    def get_sequences(self):
        return self.sequences


def main():
    sequence = Sequence(num)
    flag = False

    for _ in range(num):
        flag = sequence.find(int(In()))
        if not flag:
            break

    if flag:
        answer = sequence.get_sequences()
        print('\n'.join(answer))
    else:
        print('NO')


if __name__ == "__main__":
    main()
