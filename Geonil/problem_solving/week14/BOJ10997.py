# 별찍기 - 22
import sys
In = sys.stdin.readline

n = int(In())


class Star():
    def __init__(self, n):
        self.num = n
        self.row = (n-1)*2
        self.col = (n-1)*4 + 1
        self.stars = []

    def upper(self):
        iteration = self.row + 1
        for r in range(iteration):
            left = (r+1)//2
            right = max(0, left-1)
            mid = self.col - (left+right)*2

            line = []
            line.append('* '*left)
            if r % 2 == 0:
                line.append('*'*mid)
            else:
                if right != 0:
                    line.append(' '*mid)
            line.append(' *'*right)
            self.stars.append(line)

    def middle(self):
        line = ['* ']*(self.col//2+1)
        for _ in range(2):
            self.stars.append(line)

    def lower(self):
        iteration = self.row
        for r in range(iteration-1, -1, -1):
            left = (r+1)//2
            mid = self.col - left*4

            line = []
            line.append('* '*left)
            if r % 2 == 0:
                line.append('*'*mid)
            else:
                line.append(' '*mid)
            line.append(' *'*left)

            self.stars.append(line)

    def print_answer(self):
        self.upper()
        self.middle()
        self.lower()
        for line in self.stars:
            print(''.join(line))


def main():
    if n == 1:
        print('*')
    else:
        star = Star(n)
        star.print_answer()


if __name__ == "__main__":
    main()
