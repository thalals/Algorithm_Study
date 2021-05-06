# 회문 Palindrome (BOJ 17609)
# 시간초과 : 재귀
# 반복 : 해결
import sys
In = sys.stdin.readline
sys.setrecursionlimit(10**6)

# ====시간초과====
# def check_palindrome(string: str, left: int, right: int, flag: bool) -> int:
#     if left >= right:
#         if flag:
#             return 1
#         else:
#             return 0

#     if string[left] == string[right]:
#         return check_palindrome(string, left+1, right-1, flag)
#     else:
#         if string[left+1] == string[right] or string[left] == string[right-1]:
#             if flag:
#                 return 2
#             flag = True
#             return min(check_palindrome(string, left+1, right, flag), check_palindrome(string, left, right-1, flag))
#         else:
#             return 2


def check_palindrome(string: str) -> int:
    left = 0
    right = len(string)-1

    while True:
        if left >= right:
            break

        if string[left] == string[right]:
            left += 1
            right -= 1
            continue

        f = [1, 0]

        for i, j in enumerate(f):
            l = left + i
            r = right - j
            flag = False
            while True:
                if l >= r:
                    flag = True
                    break

                if string[l] == string[r]:
                    l += 1
                    r -= 1
                    continue
                break
            if flag:
                return 1
        return 2
    return 0


def main():
    t = int(In())
    for _ in range(t):
        string = In().rstrip()
        print(check_palindrome(string))


if __name__ == "__main__":
    main()
