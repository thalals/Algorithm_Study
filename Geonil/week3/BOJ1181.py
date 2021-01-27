import sys
from collections import defaultdict
In = sys.stdin.readline


def main():
    num = int(In())
    d_dict = defaultdict(list)  # default_dict

    # read words
    for _ in range(num):
        word = str(In().rstrip())
        if word not in d_dict[len(word)]:
            d_dict[len(word)].append(word)

    # sort
    keys = []
    for key in d_dict.keys():
        keys.append(key)
        d_dict[key].sort()
    keys.sort()

    # print
    for key in keys:
        for item in d_dict[key]:
            print(item)


main()
