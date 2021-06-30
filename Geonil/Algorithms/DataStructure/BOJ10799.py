'''
problem : 쇠막대기 (BOJ 10799)
comment : stack이용, flag 통해 레이저인지 막대기 끝인지 확인
'''
import sys
In = sys.stdin.readline


def solve(batch):
    stack = []
    num = 0
    flag = True

    for c in batch:
        if c == '(':
            stack.append(c)
            flag = True
        else:
            check = stack.pop()
            if flag:
                num += len(stack)
                flag = False
            else:
                num += 1

    return num


def main():
    batch = In().rstrip()
    print(solve(batch))


if __name__ == "__main__":
    main()
