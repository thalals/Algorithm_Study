import sys
In = sys.stdin.readline


def main():
    num = int(In())
    person_list = []

    for _ in range(num):
        person_list.append(list(map(int, In().split())))

    bulk = []

    for i in range(num):
        cnt = 1
        my_fat = person_list[i][0]
        my_tall = person_list[i][1]
        for j in range(num):
            other_fat = person_list[j][0]
            other_tall = person_list[j][1]
            if my_fat < other_fat and my_tall < other_tall:
                cnt += 1
        bulk.append(cnt)

    for cnt in bulk:
        print(cnt, end=' ')


main()
