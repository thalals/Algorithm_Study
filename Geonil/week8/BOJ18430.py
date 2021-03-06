import sys

In = sys.stdin.readline

n, m = map(int, In().split())
wood = []
for _ in range(m):
    sub = list(map(int, In().split()))
    wood.append(sub)

flag = [
    [[-1, 0], [0, 1]],
    [[-1, 0], [0, -1]],
    [[0, 1], [1, 0]],
    [[0, -1], [1, 0]]
]

visited = []


def solve():

    for i in range(n):
        for j in range(m):
            center = wood[i][j]


def main():
    if n == 1 or m == 1:
        print(0)
    else:
        print(2)


if __name__ == "__main__":
    main()
