import sys

n ,m = map(int , sys.stdin.readline().split())

pkm = []
pkm_num = {}

for i in range(n):

    pk = input()
    pkm.append(pk)
    pkm_num[pk] = i + 1

for i in range(m):

    result = sys.stdin.readline()

    if result.isdigit():
        print(pkm[int(result)-1])
    else:
        print(pkm_num[result])