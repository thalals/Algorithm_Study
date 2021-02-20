import sys
from collections import defaultdict
In = sys.stdin.readline

n = int(In())
visited = [False]*(n+1)
check_arr = []
d_dict = defaultdict(list)


for _ in range(n-1):
    v1, v2 = map(int, In().split())
    d_dict[v1].append(v2)
    d_dict[v2].append(v1)

user_answer = In().rstrip()


def dfs(x):
    if not visited[x]:
        visited[x] = True
        check_arr.append(str(x))
        check_arr.append(' ')

        for v in d_dict[x]:
            if not visited[v]:
                dfs(v)


def main():
    for key in d_dict:
        d_dict[key].sort()

    dfs(1)

    answer = ''.join(check_arr[:-1])
    print(answer)

    if answer == user_answer:
        print(1)
    else:
        print(0)


if __name__ == "__main__":
    main()
