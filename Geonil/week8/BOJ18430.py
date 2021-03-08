import sys
import copy

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
answer = 0


def check_pos(x, y, visited):
    pos_flag = []

    for idx, f in enumerate(flag):
        check = True
        for diff in f:
            dx, dy = diff
            nx = x + dx
            ny = y + dy

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                check = False
            else:
                if visited[nx][ny]:
                    check = False
        if check:
            pos_flag.append(idx)

    return pos_flag


def sum_strength(x, y, f, new_visited):
    # new_visited = copy.deepcopy(visited)
    st = wood[x][y]*2
    new_visited[x][y] = 1
    for dx, dy in flag[f]:
        st += wood[x+dx][y+dy]
        new_visited[x+dx][y+dy] = 1

    return st, new_visited


def solve(visited, strength):
    global answer
    for i in range(n):
        for j in range(m):
            checking = check_pos(i, j, visited)
            for c in checking:
                new_strength, new_visited = sum_strength(i, j, c, visited)
                new_strength += strength
                answer = max(answer, new_strength)
                print(answer)
                solve(new_visited, new_strength)


def main():
    global answer
    visited = [[0]*5 for _ in range(5)]

    if n == 1 or m == 1:
        print(0)
    else:
        solve(visited, 0)
        print(answer)


if __name__ == "__main__":
    main()
