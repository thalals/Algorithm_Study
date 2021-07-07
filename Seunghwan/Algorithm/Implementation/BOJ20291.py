n = int(input())

result = dict()

for i in range(n):
    tmp = (input().split('.'))[1]
    if not tmp in result:
        result[tmp] = 1
    else:
        result[tmp] += 1

result = sorted(result.items())

for key, value in result:
    print(key, value)
