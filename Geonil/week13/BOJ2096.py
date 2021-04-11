# 내려가기
import sys
In = sys.stdin.readline


def main():
    n = int(In())

    number_table = []
    for _ in range(n):
        number_table.append(list(map(int, In().split())))

    maximum = [[0 for i in range(3)] for j in range(n+1)]
    minimum = [[0 for i in range(3)] for j in range(n+1)]

    # 0 -> 0, 1
    # 1 -> 0, 1, 2
    # 2 -> 1, 2
    for line, numbers in enumerate(number_table):
        # maximum
        maximum[line+1][0] = max(maximum[line][0] +
                                 numbers[0], maximum[line][1]+numbers[0])
        maximum[line+1][1] = max(maximum[line][0] + numbers[1],
                                 maximum[line][1]+numbers[1], maximum[line][2]+numbers[1])
        maximum[line+1][2] = max(maximum[line][1] +
                                 numbers[2], maximum[line][2] + numbers[2])
        # minimum
        minimum[line+1][0] = min(minimum[line][0] +
                                 numbers[0], minimum[line][1]+numbers[0])
        minimum[line+1][1] = min(minimum[line][0] + numbers[1],
                                 minimum[line][1]+numbers[1], minimum[line][2]+numbers[1])
        minimum[line+1][2] = min(minimum[line][1] +
                                 numbers[2], minimum[line][2] + numbers[2])

    print(max(maximum[n]), min(minimum[n]))


if __name__ == "__main__":
    main()
