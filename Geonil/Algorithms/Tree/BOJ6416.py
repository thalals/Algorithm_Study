# 트리인가? (BOJ 6416)
import sys
from collections import deque, defaultdict
In = sys.stdin.readline


def main():
    case = 1

    while True:
        degree = defaultdict(int)
        flag = False
        while True:
            lst = list(map(str, In().rstrip().split()))
            print(lst)
            for node in lst:
                u, v = map(int, node.split())
                if u == 0 and v == 0:
                    flag = True
                    break
                if not degree[u]:
                    degree[u] = 0
                degree[v] += 1
            if flag:
                break

        root_cnt = 0
        degree_flag = True
        for k, v in degree.items():
            if v == 0:
                root_cnt += 1
            if v > 1:
                degree_flag = False
                break
        if (root_cnt == 1 and degree_flag) or not degree:
            print(f'Case {case} is a tree.')
        else:
            print(f'Case {case} is not a tree.')
        case += 1

        end = In().split()
        if not len(end) == 0:
            break


if __name__ == "__main__":
    main()
