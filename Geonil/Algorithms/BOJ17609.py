# 회문 Palindrome (BOJ 17609)
import sys
In = sys.stdin.readline
sys.setrecursionlimit(10**6)


def check_palindrome(string: str, left: int, right: int, flag: bool) -> int:
    if left >= right:
        if flag:
            return 1
        else:
            return 0

    if string[left] == string[right]:
        return check_palindrome(string, left+1, right-1, flag)
    else:
        if string[left+1] == string[right] or string[left] == string[right-1]:
            if flag:
                return 2
            flag = True
            return min(check_palindrome(string, left+1, right, flag), check_palindrome(string, left, right-1, flag))
        else:
            return 2


def main():
    t = int(In())
    for _ in range(t):
        string = In().rstrip()
        print(check_palindrome(string, 0, len(string)-1, False))


if __name__ == "__main__":
    main()
