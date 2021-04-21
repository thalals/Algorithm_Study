# 가운데를 말해요
# 시간초과 1 : 정렬
# 시간초과 2 : list 두개 이용

import sys
In = sys.stdin.readline


class Mid():
    def __init__(self, n):
        self.lst = [0] * 20001
        self.mids = [0] * n

        self.mid = -1

        self.mc = 0
        self.lc = 0
        self.rc = 0
        self.cnt = 0

    def push(self, num):

        self.lst[num] += 1

        if self.mid == -1:
            self.mid = num
            self.mc = 1
        else:
            if num < self.mid:
                self.lc += 1
            elif num > self.mid:
                self.rc += 1
            else:
                self.mc += 1
        self.cnt += 1

        print(self.lc, self.mc, self.rc)

        # adjust mid
        if self.cnt % 2 == 0:
            if self.lc >= self.rc + self.mc:
                while True:
                    self.mid -= 1
                    if self.lst[self.mid]:
                        self.rc += self.mc
                        self.mc = self.lst[self.mid]
                        self.lc -= self.mc
                        break

        if self.cnt % 2 != 0 and (self.lc or self.rc):
            if self.lc + self.mc < self.rc:
                while True:
                    self.mid += 1
                    if self.lst[self.mid]:
                        self.lc += self.mc
                        self.mc = self.lst[self.mid]
                        self.rc -= self.mc
                        break
            elif self.rc + self.mc < self.lc:
                while True:
                    self.mid -= 1
                    if self.lst[self.mid]:
                        self.rc += self.mc
                        self.mc = self.lst[self.mid]
                        self.lc -= self.mc
                        break

        self.mids[self.cnt-1] = self.mid-10000

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
        mid.push(item+10000)

    mid.get_mids()


if __name__ == "__main__":
    main()
