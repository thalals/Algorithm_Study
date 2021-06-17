# 트리인가? (BOJ 6416)
import sys
from collections import defaultdict

In = sys.stdin.readline


class TreeAttr:
    def __init__(self):
        self.degree = defaultdict(int)
        # in degree 계산

    def insert(self, u, v):
        if not self.degree[u]:
            self.degree[u] = 0
        self.degree[v] += 1


def main():
    case = 1

    while True:
        tree = TreeAttr()
        flag = False    # 0 0 flag
        end_flag = False

        while True:
            lst = list(map(str, In().rstrip().split('  ')))
            for node in lst:
                u, v = map(int, node.split())
                if u == 0 and v == 0:
                    flag = True
                    break
                if u == -1 and v == -1:
                    end_flag = True
                    flag = True
                    break
                tree.insert(u, v)
            if flag:
                break

        if end_flag:
            break

        # check
        root_cnt = 0
        flag = True     # degree 2 이상 flag
        for k, v in tree.degree.items():
            if v == 0:      # degree 가 0인 경우
                root_cnt += 1   # root 개수 증가
            if v > 1:       # degree 가 2개 이상인 경우
                flag = False
                break

        # node가 없는경우 or 트리 조건
        if (root_cnt == 1 and flag) or not tree.degree:
            print(f'Case {case} is a tree.')
        else:
            print(f'Case {case} is not a tree.')
        case += 1

        # -1 -1이면 종료
        end = In().split()
        if not len(end) == 0:
            break


if __name__ == "__main__":
    main()
