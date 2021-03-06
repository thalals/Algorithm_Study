import sys
In = sys.stdin.readline

n, m = map(int, In().split())

poketmons = []
poketmons_dict = {}
for i in range(n):
    poketmon = In().rstrip()
    poketmons.append(poketmon)
    poketmons_dict[poketmon] = i+1


def main():
    for _ in range(m):
        question = In().rstrip()
        if question.isdigit():
            print(poketmons[int(question)-1])
        else:
            print(poketmons_dict[question])


if __name__ == "__main__":
    main()
