# 가운데를 말해요
# 시간초과 1 : 정렬
# 시간초과 2 : list 두개 이용
# 시간초과 3 : left, right 개수, index 이용
# 해결 : heapq(우선순위 큐) 이용 left, right
import sys
import heapq
In = sys.stdin.readline


class MaxHeap():
    def __init__(self):
        self.heap = []
        self.cnt = 0

    def push(self, num):
        heapq.heappush(self.heap, (-num, num))

    def pop(self):
        return heapq.heappop(self.heap)[1]

    def get_length(self):
        return len(self.heap)


class MinHeap():
    def __init__(self):
        self.heap = []

    def push(self, num):
        heapq.heappush(self.heap, num)

    def pop(self):
        return heapq.heappop(self.heap)

    def get_length(self):
        return len(self.heap)


class Mid():
    def __init__(self, n):
        self.left = MaxHeap()
        self.right = MinHeap()
        self.mids = [0] * n
        self.mid = 0
        self.cnt = 0

    def push(self, num):

        if self.cnt == 0:
            self.mid = num
        else:
            if self.mid < num:
                self.right.push(num)
            else:
                self.left.push(num)
        self.cnt += 1

        lc = self.left.get_length()
        rc = self.right.get_length()
        # adjust mid
        if self.cnt % 2 == 0:
            if lc > rc:
                self.right.push(self.mid)
                self.mid = self.left.pop()
        else:
            if lc or rc:
                if lc < rc:
                    self.left.push(self.mid)
                    self.mid = self.right.pop()
                elif rc < lc:
                    self.right.push(self.mid)
                    self.mid = self.left.pop()

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
