'''
problem : 카드2 (BOJ 2164)
comment : deque 이용
'''
import sys
from collections import deque
In = sys.stdin.readline


class Card:
    def __init__(self, n):
        self.card = deque([i for i in range(1, n+1)])

    def drop(self):
        self.card.popleft()

    def move(self):
        self.card.append(self.card.popleft())

    def shuffle(self):
        while True:
            if len(self.card) == 1:
                break
            self.drop()
            self.move()

        return self.card.pop()


def main():
    n = int(In())
    card = Card(n)
    print(card.shuffle())


if __name__ == "__main__":
    main()
