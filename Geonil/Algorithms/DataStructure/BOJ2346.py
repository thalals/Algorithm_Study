'''
problem : 풍선 터뜨리기 (BOJ 2346)
comment : 
'''
import sys
from collections import deque, defaultdict
In = sys.stdin.readline


class Balloon(object):
    def __init__(self, n):
        self.circle = deque([i for i in range(n)])
        self.n = n

    def moving(self, mode):
        if mode == 0:
            self.circle.append(self.circle.popleft())
        else:
            self.circle.appendleft(self.circle.pop())

    def pop(self, papers):
        answer = []
        cnt = 0

        while True:
            if cnt == self.n-1:
                num = self.circle.popleft()
                answer.append(num+1)
                break

            num = self.circle.popleft()
            move = papers[num]
            mode = 0 if move > 0 else 1
            move = abs(move)
            if mode:
                move += 1
            for i in range(move-1):
                self.moving(mode)

            answer.append(num+1)
            cnt += 1

        return answer


def main():
    n = int(In())
    papers = list(map(int, In().split()))

    balloons = Balloon(n)
    order = balloons.pop(papers)
    print(' '.join(list(map(str, order))))


if __name__ == "__main__":
    main()
