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
            if self.mid <= num:
                if self.right:
                    for i in range(self.rc):
                        if self.right[i] <= num:
                            self.right.insert(i, num)
                            break
                    if num < self.right[i]:
                        self.right.append(num)
                else:
                    self.right.append(num)
                self.rc += 1
            else:
                if self.left:
                    for i in range(self.lc):
                        if num < self.left[i]:
                            self.left.insert(i, num)
                            break
                    if num > self.left[i]:
                        self.left.append(num)
                else:
                    self.left.append(num)
                self.lc += 1
        self.cnt += 1

        # adjust mid
        if self.cnt % 2 != 0 and (self.left or self.right):
            if self.lc < self.rc:
                self.left.append(self.mid)
                self.mid = self.right.pop()
                self.lc += 1
                self.rc -= 1
            elif self.lc > self.rc:
                self.right.append(self.mid)
                self.mid = self.left.pop()
                self.lc -= 1
                self.rc += 1

        if self.cnt % 2 == 0 and (self.lc > self.rc):
            self.right.append(self.mid)
            self.mid = self.left.pop()
            self.rc += 1
            self.lc -= 1

        # check
        # print(self.left, self.mid, self.right[::-1])
        self.mids[self.cnt-1] = self.mid

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
