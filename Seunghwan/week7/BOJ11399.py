n = int(input())
s = list(map(int,input().split()))
result =0
count = 0

s.sort()

for i in s:
    count += i
    result += count

print(result)