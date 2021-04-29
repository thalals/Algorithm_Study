import sys
from collections import defaultdict
In = sys.stdin.readline


def main():
    num = int(In())
    d_dict = defaultdict(list)  # default dict

    # read data
    # key:age, value:name
    for _ in range(num):
        age, name = map(str, In().split())
        d_dict[int(age)].append(name)

    # sort age
    keys = list(d_dict.keys())
    keys.sort()

    # print
    for key in keys:
        for item in d_dict[key]:
            print(key, item)


main()
