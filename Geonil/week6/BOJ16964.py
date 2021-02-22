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

user_answer = list(map(int, In().split()))
cnt = 0


def dfs(x):
    global cnt

    if not visited[x]:
        visited[x] = True
        # print('visit ', x)

        for _ in range(len(d_dict[x])):
            if cnt < len(user_answer):
                v = user_answer[cnt]
                if v in d_dict[x]:
                    if not visited[v]:
                        cnt += 1
                        dfs(v)


def main():
    global cnt

    if user_answer[cnt] == 1:
        cnt += 1
        dfs(1)

    if cnt == len(user_answer):
        print(1)
    else:
        print(0)


if __name__ == "__main__":
    main()
