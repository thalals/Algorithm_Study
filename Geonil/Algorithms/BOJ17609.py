# 회문 Palindrome (BOJ 17609)
import sys
In = sys.stdin.readline


def check_palindrome(string: str) -> int:
    length = len(string)
    pesudo_flag = False
    mid = length//2

    if length % 2 == 0:
        left = mid-1
        right = mid

        while True:
            if left < 0 or length <= right:
                break
            if string[left] == string[right]:
                left -= 1
                right += 1
                continue

            if left-1 < 0 or length <= right+1:
                return 2

            if not pesudo_flag:
                pesudo_flag = True
            else:
                return 2

            if string[left-1] == string[right+1]:
                left -= 1
                right += 1
            else:
                return 2
    else:
        left = mid-1
        right = mid+1

        if not string[left] == string[right]:
            if string[mid] == string[right]:
                left = mid
                pesudo_flag = True
            elif string[mid] == string[left]:
                right = mid
                pesudo_flag = True

        while True:
            if left < 0 or length <= right:
                break

            if string[left] == string[right]:
                left -= 1
                right += 1
                continue

            return 2

            # if not pesudo_flag:
            #     pesudo_flag = True
            # else:
            #     return 2

            # if string

    if pesudo_flag:
        return 1
    return 0


def main():
    t = int(In())
    for _ in range(t):
        string = In().rstrip()
        print(check_palindrome(string))


if __name__ == "__main__":
    main()
