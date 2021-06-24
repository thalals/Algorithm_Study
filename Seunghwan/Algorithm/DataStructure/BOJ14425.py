n, m = map(int, input().split())

data = {input() for i in range(n)}
# 구글링하다가 위처럼 줄이는 방법을 배웠다.

count = 0

for j in range(m):
    temp = input()
    if temp in data:  # dict에 있는지 체크
        count += 1
print(count)
