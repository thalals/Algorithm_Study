# 가운데를 말해요
import sys
In = sys.stdin.readline


class Mid():
    def __init__(self, n):
        self.left = []
        self.right = []
        self.mid = 0
        self.mids = [0] * n
        self.cnt = 0
        self.lc = 0
        self.rc = 0

    def push(self, num):
        if self.cnt == 0:
            self.mid = num
        else:
            if self.lc == 0 or self.rc == 0:
                pass
            else:
                if self.mid < num:

                    pass
                elif self.mid > num:
                    pass
                else:
                    pass

        # 미드 조정
        if self.lc < self.rc:
            self.left.append(self.mid)
            self.mid = self.right[self.rc-1].pop()
            self.lc += 1
            self.rc -= 1
        else:
            self.right.append(self.mid)
            self.mid = self.left[self.lc-1].pop()
            self.lc -= 1
            self.rc += 1
            pass
        self.cnt += 1

    def get_mids(self):
        s = ''
        for item in self.mids:
            s += (str(item)+'\n')
        print(s)


def main():
    n = int(In())
    mid = Mid(n)
    numbers = [0] * n

    for i in range(n):
        numbers[i] = int(In())

    for item in numbers:
        mid.push(item)

    mid.get_mids()


if __name__ == "__main__":
    main()
