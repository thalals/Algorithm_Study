import sys

input = sys.stdin.readline

result = {}
n = 0

while True:
    data = input().rstrip()
    if not data:
        break
    if data in result:
        result[data] += 1
    else:
        result[data] = 1
    n += 1

result_set = list(result.keys())
result_set.sort()

for data in result_set:
    print('%s %.4f' % (data, result[data]/n*100))
