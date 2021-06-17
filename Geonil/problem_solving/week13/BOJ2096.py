# 내려가기
import sys
In = sys.stdin.readline


def main():
    n = int(In())

    maximum = [[0] * 3 for _ in range(2)]
    minimum = [[0] * 3 for _ in range(2)]

    for line in range(n):
        numbers = list(map(int, In().split()))
        # maximum
        maximum[1][0] = max(maximum[0][0] +
                            numbers[0], maximum[0][1]+numbers[0])
        maximum[1][1] = max(maximum[0][0] + numbers[1],
                            maximum[0][1]+numbers[1], maximum[0][2]+numbers[1])
        maximum[1][2] = max(maximum[0][1] +
                            numbers[2], maximum[0][2] + numbers[2])
        # minimum
        minimum[1][0] = min(minimum[0][0] +
                            numbers[0], minimum[0][1]+numbers[0])
        minimum[1][1] = min(minimum[0][0] + numbers[1],
                            minimum[0][1]+numbers[1], minimum[0][2]+numbers[1])
        minimum[1][2] = min(minimum[0][1] +
                            numbers[2], minimum[0][2] + numbers[2])

        maximum[0], maximum[1] = maximum[1], [0]*3
        minimum[0], minimum[1] = minimum[1], [0]*3

    print(max(maximum[0]), min(minimum[0]))


if __name__ == "__main__":
    main()
