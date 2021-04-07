# 전구 장식
import sys
In = sys.stdin.readline

# 한번 사용 -> 다음해까지 사용 x
# 교대패턴, 1번만사용해 가장 긴 교대 패턴


def main():
    n = int(In())
    bulbs = list(map(int, In().split()))

    idx = 0
    length = 0

    while True:

        if bulbs[idx] == bulbs[idx+1] and bulbs[idx+1] != bulbs[idx+2]:
            start = idx+1
            finish = idx+2

            while True:
                if bulbs[finish] == bulbs[finish+1]:
                    break
                finish += 1

            length = max(length, finish-start+3)

        idx += 1

        if idx == n:
            break

    print(length)


if __name__ == "__main__":
    main()
