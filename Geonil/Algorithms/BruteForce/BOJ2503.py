"""
problem : 숫자 야구 (BOJ 2503)
comment : set 이용
"""
import sys

In = sys.stdin.readline

numbers = []

for i in range(1, 10):
    for j in range(1, 10):
        for k in range(1, 10):
            if i == j or j == k or i == k:
                continue
            num = i * 100 + j * 10 + k
            numbers.append(num)
possible = set(numbers)


def check(n, m):
    n, m = str(n), str(m)
    s_n, s_m = set(n), set(m)
    inner = s_n.intersection(s_m)
    strike, ball = 0, 0

    for c1, c2 in zip(n, m):
        if c1 == c2:
            strike += 1
            inner.discard(c1)
    ball = len(inner)
    return strike, ball


def guess(num, strike, ball):
    for n in numbers:
        s, b = check(num, n)
        if not s == strike or not b == ball:
            possible.discard(n)


def main():
    n = int(In())
    for _ in range(n):
        number, strike, ball = map(int, In().split())
        guess(number, strike, ball)

    print(len(possible))


if __name__ == "__main__":
    main()
